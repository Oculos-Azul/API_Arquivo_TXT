import java.util.Scanner;

import utils.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner); 
        menu.show(); 
    }
}
