import java.util.Scanner;
import java.util.UUID;

import controller.AnimeController;
import dto.AnimeDTO;

public class Main {
	static Scanner read = new Scanner(System.in);
	static AnimeController controller = new AnimeController();
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		renderMenu();
		processMenuChoice(read.nextInt());
	}
	
	private static void renderMenu() {
		System.out.println("Banco de Dados Animes");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Atualizar");
		System.out.println("3 - Listar");
		System.out.println("4 - Pesquisar");
		System.out.println("5 - Deletar");
	}
	
	private static void processMenuChoice(int choice) {
		switch(choice) {
		case 1:
			menuToCreate();
			break;
		case 2:
			controller.menuToUpdate();
			break;
		case 3:
			controller.menuToFindAll();
			break;
		case 4:
			controller.menuToFindById();
			break;
		case 5:
			controller.menuToDelete();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Digite um valor válido para  menu.");
			break;
		}
	}
	
    private static String[] menuToCreate() {
        String[] registrationDetails = new String[6];
        System.out.println("Digite o nome do anime.");
        registrationDetails[0] = read.nextLine();
        System.out.println("Digite o gênero de " + registrationDetails[0]);
        registrationDetails[1] = read.nextLine();
        System.out.println("Digite o nome do autor de " + registrationDetails[0]);
        registrationDetails[2] = read.nextLine();
        System.out.println("Digite o ano de lançamento de " + registrationDetails[0]);
        registrationDetails[3] = String.valueOf(read.nextInt());
        System.out.println("Digite a quantidade de episódios de " + registrationDetails[0]);
        registrationDetails[4] = String.valueOf(read.nextInt());
        read.nextLine(); // Consumir quebra de linha
        System.out.println("Digite o ID do estúdio que anima " + registrationDetails[0]);
        registrationDetails[5] = read.nextLine();
        return registrationDetails;
    }

    private UUID requestAnimeId() {
        System.out.println("Digite o ID do anime que deseja realizar a operação:");
        return UUID.fromString(read.nextLine());
    }

    private AnimeDTO createAnimeDTO(String[] registrationDetails) {
        return new AnimeDTO(
                registrationDetails[0],
                registrationDetails[1],
                registrationDetails[2],
                Integer.parseInt(registrationDetails[3]),
                Integer.parseInt(registrationDetails[4]),
                UUID.fromString(registrationDetails[5])
        );
    }
}
