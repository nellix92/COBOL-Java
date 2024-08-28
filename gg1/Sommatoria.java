package esercizi.gg1;

import java.util.Scanner;

public class Sommatoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il valore di K: ");
        int K = scanner.nextInt();
        System.out.print("Inserisci il valore di N: ");
        int N = scanner.nextInt();

        long sommatoria = 0;
        long potenza = K;

        for (int i = 1; i <= N; i++) {
            sommatoria += potenza;
            potenza *= K;
        }

        System.out.println("La sommatoria K + K^2 + K^3 + ... + K^N è: " + sommatoria);

	}

}
