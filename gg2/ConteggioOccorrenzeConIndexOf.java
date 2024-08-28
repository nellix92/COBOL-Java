package esercizi.gg2;

import java.util.Scanner;

public class ConteggioOccorrenzeConIndexOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una stringa: ");
        String input = scanner.nextLine();

        System.out.print("Inserisci il carattere da contare: ");
        char carattere = scanner.next().charAt(0);

        int count = contaOccorrenzeConIndexOf(input, carattere);

        System.out.println("Il carattere '" + carattere + "' appare " + count + " volte nella stringa.");
    }

    public static int contaOccorrenzeConIndexOf(String input, char carattere) {
        int count = 0;
        int index = input.indexOf(carattere); 
        while (index != -1) {
            count++;
            index = input.indexOf(carattere, index + 1); 
        }
        return count;
    }
}
