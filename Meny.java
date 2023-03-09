import java.util.Scanner;

public class Meny {
    public static void showMainMenu() {
        System.out.println("1. Spela");
        System.out.println("2. Lägg till nytt ord");
        System.out.println("3. Ta bort ord");
        System.out.println("4. Se lista på ord");
        System.out.println("5. Avsluta");
    }

    public static int askForNumber(int min, int max) {
        int choice = 0;
        if(choice > 0 || choice < max) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Skriv in ett nummer mellan " + min + " och " + max);
            choice = sc.nextInt();
        }
        return choice;
    }
}

