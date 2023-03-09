import java.util.*;

public class Spelet {
    ArrayList<Character> gissadeBokstäver;
    Ordlista ordlista;
    Ord ord;
    Spelare spelare;

    public Spelet() {
        this.ordlista = new Ordlista();
    }

    boolean play = true;
    boolean continuePlaying = true;

    public void startaSpel() {
        String name = askForName();
        spelare = new Spelare(name);
        welcomePlayer(name);
        while (continuePlaying) {
            Meny.showMainMenu();
            int choice = Meny.askForNumber(1, 5);
            switch (choice) {
                case 1 -> play = true;
                case 2 -> ordlista.addWord();
                case 3 -> ordlista.removeWord();
                case 4 -> ordlista.showWords();
                case 5 -> endGame();
                default -> System.out.println("Ogiltigt val");
            }
            while (play) {
                Scanner sc = new Scanner(System.in);
                gissadeBokstäver = new ArrayList<>();
                ord = new Ord(ordlista.slumpOrd());
                System.out.println("Ordet har " + ord.getOrd().length() + " bokstäver. ");
                while (ord.harVunnit() == false) {//efter
                    System.out.println("Gissade bokstäver: ");
                    printGuessedLetters(gissadeBokstäver);
                    makeAGuess();
                    char guess = sc.next().charAt(0);
                    ord.visaBokstav(guess);
                    gissadeBokstäver.add(guess);
                    spelare.increaseGuesses();
                    System.out.println(ord.getGissning());
                    if (ord.harVunnit() == true) {
                        spelare.increaseScore();
                        congrats(ord.getOrd());
                        System.out.println("\nGrymt " + spelare.getName() + "!! Du klarade det på " + spelare.guesses + " försök. \n" +
                                "Du har " + spelare.getScore() + " poäng.");
                        spelare.resetGuesses();
                        play = false;
                    }
                }
            }
            continuePlaying = true;
        }
    }

    public String askForName () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Välkommen till Hänga gubbe! Skriv in ditt namn.");
        return sc.nextLine();
    }

    public void welcomePlayer (String name){
        System.out.println("Välkommen " + name);
    }

    public static void printGuessedLetters(ArrayList<Character> arraylist) {
        for (Character c : arraylist) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }

    public void makeAGuess () {
        System.out.println("Gör en gissning: ");
    }

    public void congrats(String word) {
        System.out.println("Grattis! Ordet var " + word + ".");
    }

    private void endGame() {
        System.out.println("Tack för att du spelade!");
        System.exit(0);
    }
}

