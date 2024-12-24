package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import exceptions.ValidationException;
import exceptions.InvalidUUIDException;
import dto.AnimeDTO;
import controller.AnimeController;

public class Menu {
    private Scanner scanner;
    private AnimeController animeController;
    private boolean isRunning = true;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.animeController = new AnimeController();
    }

    public void show() {
        while (isRunning) {
            printMenu();
            int option = getIntInput("Escolha uma opção: ");

            if (!handleOption(option)) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nMenu de Animes:");
        System.out.println("1. Criar Anime");
        System.out.println("2. Listar Animes");
        System.out.println("3. Buscar Anime");
        System.out.println("4. Atualizar Anime");
        System.out.println("5. Deletar Anime");
        System.out.println("6. Sair");
    }

    private boolean handleOption(int option) {
        switch (option) {
            case 1 -> createAnime();
            case 2 -> listAnimes();
            case 3 -> findAnimeById();
            case 4 -> updateAnime();
            case 5 -> deleteAnime();
            case 6 -> {
                System.out.println("Saindo...");
                isRunning = false;
                return true;
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next();
        }
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private void createAnime() {
        try {
            AnimeDTO animeDTO = collectAnimeData();
            if (animeController.toCreate(animeDTO)) {
                System.out.println("Anime criado com sucesso!");
            }
        } catch (ValidationException | IOException | ClassNotFoundException ex) {
            System.err.println("Erro ao criar o anime: " + ex.getMessage());
        } catch (InputMismatchException ex) {
            System.err.println("Valor digitado inválido. Por favor, tente novamente.");
            scanner.nextLine();
        }
    }

    private void listAnimes() {
        try {
            System.out.println("\nListando todos os animes:");
            animeController.toList().forEach((name, anime) -> System.out.println(anime));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao listar os animes: " + e.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void findAnimeById() {
        try {
            String name = getStringInput("\nDigite o ID do anime para buscar: ");
            System.out.println(animeController.toSearch(name));
        } catch (InvalidUUIDException | IOException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar o anime: " + e.getMessage());
        }
    }

    private void updateAnime() {
        try {
            String name = getStringInput("Digite o ID do anime a ser atualizado: ");
            String field = getStringInput("Digite o campo a ser atualizado (name, genre, authorname, releaseyear, episodecount, studio): ");
            String value;

            if (field.equalsIgnoreCase("releaseyear") || field.equalsIgnoreCase("episodecount")) {
                int numericValue = getIntInput("Digite um valor numérico válido para o campo " + field + ": ");
                value = String.valueOf(numericValue);
            } else {
                value = getStringInput("Digite o novo valor para o campo " + field + ": ");
            }

            animeController.toUpdate(name, value, field);
            System.out.println("Anime atualizado com sucesso!");
        } catch (ValidationException | IOException | ClassNotFoundException e) {
            System.err.println("Erro ao atualizar o anime: " + e.getMessage());
        }
    }

    private void deleteAnime() {
        try {
            String name = getStringInput("\nDigite o ID do anime a ser deletado: ");
            animeController.toDelete(name);
            System.out.println("Anime deletado com sucesso!");
        } catch (ValidationException | IOException | ClassNotFoundException e) {
            System.out.println("Erro ao deletar o anime: " + e.getMessage());
        }
    }

    private AnimeDTO collectAnimeData() {
        String name = getStringInput("Digite o nome do anime: ");
        String genre = getStringInput("Digite o gênero do anime: ");
        String authorName = getStringInput("Digite o nome do autor: ");
        int releaseYear = getIntInput("Digite o ano de lançamento: ");
        int episodeCount = getIntInput("Digite a quantidade de episódios: ");
        String studio = getStringInput("Digite o ID do estúdio: ");
        return new AnimeDTO(name, genre, authorName, releaseYear, episodeCount, studio);
    }
}
