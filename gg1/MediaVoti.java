package esercizi.gg1;

import java.util.Scanner;

public class MediaVoti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] voti = new int[10];
        int somma = 0;

        System.out.println("Inserisci 10 voti di esame (compresi tra 18 e 30):");
        for (int i = 0; i < 10; i++) {
            int voto;
            do {
                System.out.print("Inserisci il voto " + (i + 1) + ": ");
                voto = scanner.nextInt();
                if (voto < 18 || voto > 30) {
                    System.out.println("Voto non valido. Riprova.");
                }
            } while (voto < 18 || voto > 30);
            voti[i] = voto;
            somma += voto;
        }

        double media = (double) somma / 10;
        System.out.println("La media aritmetica dei voti è: " + media);
    }
    
}
