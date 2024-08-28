package esercizi.gg2;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Quanti numeri vuoi giocare (1-10)? ");
        int numGiocati = scanner.nextInt();
        while (numGiocati < 1 || numGiocati > 10) {
            System.out.print("Numero non valido. Inserisci un numero tra 1 e 10: ");
            numGiocati = scanner.nextInt();
        }

        int[] numeriGiocati = new int[numGiocati];
        System.out.println("Inserisci " + numGiocati + " numeri tra 1 e 90 (tutti diversi):");
        for (int i = 0; i < numGiocati; i++) {
            int numero;
            boolean numeroValido;
            do {
                numero = scanner.nextInt();
                numeroValido = numero >= 1 && numero <= 90 && !contieneNumero(numeriGiocati, i, numero);
                if (!numeroValido) {
                    System.out.println("Numero non valido o già inserito. Inserisci un numero diverso.");
                }
            } while (!numeroValido);
            numeriGiocati[i] = numero;
        }

        int[] numeriEstratti = new int[5];
        for (int i = 0; i < 5; i++) {
            int numero;
            do {
                numero = random.nextInt(90) + 1;
            } while (contieneNumero(numeriEstratti, i, numero));
            numeriEstratti[i] = numero;
        }

        int numeriIndovinati = contaNumeriIndovinati(numeriGiocati, numeriEstratti);

        System.out.print("Numeri estratti: ");
        stampaArray(numeriEstratti);
        System.out.println("Hai indovinato " + numeriIndovinati + " numeri.");

    }

    private static boolean contieneNumero(int[] array, int posizioneMassima, int numero) {
        for (int i = 0; i <= posizioneMassima; i++) {
            if (array[i] == numero) {
                return true;
            }
        }
        return false;
    }

    private static int contaNumeriIndovinati(int[] numeriGiocati, int[] numeriEstratti) {
        int count = 0;
        for (int numeroGiocato : numeriGiocati) {
            for (int numeroEstratto : numeriEstratti) {
                if (numeroGiocato == numeroEstratto) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}


