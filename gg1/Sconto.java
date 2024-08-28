package esercizi.gg1;

import java.util.Scanner;

public class Sconto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sconto;
		double prezzoScontato;
		boolean isContinue = true;
		Scanner s = new Scanner (System.in);
		while (isContinue) {
			System.out.println("Inserisci il prezzo del prodotto");
			double prezzo = s.nextDouble();
			if(prezzo > 100) {
				sconto = prezzo * 0.20;
			}
			else if (prezzo >= 50) {
				sconto = prezzo * 0.10;
			}
			else {
				sconto = prezzo * 0.05;
			}
		
			prezzoScontato = prezzo - sconto;
			System.out.println("Il prezzo scontato è: "+prezzoScontato);
			System.out.println("Vuoi comntinuare? 1-->Yes//2---->No");
			int choice = s.nextInt();
			if(choice == 2)
			{
				isContinue = false;
			}
		}
	}

}
