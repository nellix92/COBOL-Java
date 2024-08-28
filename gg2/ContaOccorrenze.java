package esercizi.gg2;

import java.util.Scanner;

public class ContaOccorrenze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una stringa: ");
        String input = scanner.nextLine();

        System.out.print("Inserisci un carattere: ");
        char carattere = scanner.next().charAt(0);

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == carattere) {
                count++;
            }
        }

        System.out.println("Il carattere '" + carattere + "' appare " + count + " volte nella stringa.");
    }
}

