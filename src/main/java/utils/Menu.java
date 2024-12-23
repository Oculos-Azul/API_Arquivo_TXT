package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.io.IOException;
import exceptions.ValidationException;
import exceptions.InvalidUUIDException;
import dto.AnimeDTO;
import controller.AnimeController;

public class Menu {
    private Scanner scanner;
    private AnimeController animeController;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.animeController = new AnimeController(); 
    }

    
    public void show() {
        while (true) {
            System.out.println("\nMenu de Animes:");
            System.out.println("1. Criar Anime");
            System.out.println("2. Listar Animes");
            System.out.println("3. Buscar Anime");
            System.out.println("4. Atualizar Anime");
            System.out.println("5. Deletar Anime");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    createAnime();
                    break;
                case 2:
                    listAnimes();
                    break;
                case 3:
                    findAnimeById();
                    break;
                case 4:
                    updateAnime();
                    break;
                case 5:
                    deleteAnime();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    
    private void createAnime() {
        try {
    	System.out.println("\nDigite o nome do anime: ");
        String name = scanner.nextLine();
        System.out.println("Digite o gênero do anime: ");
        String genre = scanner.nextLine();
        System.out.println("Digite o nome do autor: ");
        String authorName = scanner.nextLine();
        System.out.println("Digite o ano de lançamento: ");
        int releaseYear = scanner.nextInt();
        System.out.println("Digite a quantidade de episódios: ");
        int episodeCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o ID do estúdio: ");
        String studio = scanner.nextLine();

        AnimeDTO animeDTO = new AnimeDTO(name, genre, authorName, releaseYear, episodeCount, studio);

        
            if (animeController.toCreate(animeDTO)) {
                System.out.println("Anime criado com sucesso!");
            }
        } catch (ValidationException | IOException | ClassNotFoundException ex) {
            System.err.println("Erro ao criar o anime: " + ex.getMessage());
        } catch (InputMismatchException ex) {
        	System.err.println("Valor digitado inválido: " + ex.getMessage());
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
        System.out.print("\nDigite o ID do anime para buscar: ");
        String name = scanner.nextLine();
        try {
            System.out.println(animeController.toSearch(name));
        } catch (InvalidUUIDException | IOException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar o anime: " + e.getMessage());
        }
    }

    
    private void updateAnime() {
        System.out.print("\nDigite o ID do anime a ser atualizado: ");
        String name = scanner.nextLine();
        System.out.print("Digite o campo a ser atualizado (name, genre, authorname, releaseyear, episodecount, studio): ");
        String field = scanner.nextLine();
        System.out.print("Digite o novo valor para o campo: ");
        String value = scanner.nextLine();
        
        try {
            animeController.toUpdate(name, value, field);
            System.out.println("Anime atualizado com sucesso!");
        } catch (ValidationException | IOException | ClassNotFoundException e) {
            System.out.println("Erro ao atualizar o anime: " + e.getMessage());
        }
    }

    
    private void deleteAnime() {
        System.out.print("\nDigite o ID do anime a ser deletado: ");
        String name = scanner.nextLine();
        try {
            animeController.toDelete(name);
            System.out.println("Anime deletado com sucesso!");
        } catch (ValidationException | IOException | ClassNotFoundException e) {
            System.out.println("Erro ao deletar o anime: " + e.getMessage());
        }
    }
}

