import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Ordlista {
    private ArrayList<String> ordlista = new ArrayList<String>();
public Ordlista() {
    ordlista.add("Maskin");
    ordlista.add("Java");
    ordlista.add("Elefant");
    ordlista.add("Fiskfotboll");
}

    public String slumpOrd() {
        int index = ((int) (Math.random() * ordlista.size()));
        String ord = ordlista.get(index);
        return ord;
    }
    public void addWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vilket ord vill du lägga till?");
        ordlista.add(sc.nextLine());
    }

    public void removeWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vilket ord vill du ta bort?");
        String ord = sc.nextLine();
        if(ordlista.contains(ord)) {
            ordlista.remove(ord);
        } else {
            System.out.println("Ordlistan innehåller inte det ordet.");
        }
    }
    public void showWords(){
        for (String ord : ordlista) {
            System.out.println(ord.toString());
        }
    }
}