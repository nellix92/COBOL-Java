package esercizi.gg1;

import java.util.Scanner;

public class InserimentoNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Inserisci un numero intero positivo: ");
            numero = scanner.nextInt();

        } while (numero < 1 || numero > 100);

        System.out.println("Hai inserito un numero corretto: " + numero);
	}

}
