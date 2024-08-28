package esercizi.gg1;

import java.util.Scanner;

public class Fattoriale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero positivo N: ");
        int N = scanner.nextInt();

        long fattoriale = 1;
        for (int i = 1; i <= N; i++) {
            fattoriale *= i;
        }

        System.out.println("Il fattoriale di " + N + " è: " + fattoriale);
    }
}
