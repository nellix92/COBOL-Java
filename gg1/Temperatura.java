package esercizi.gg1;

import java.util.Scanner;

public class Temperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double valoreSerra;
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci la temperatura della serra:");
		valoreSerra = s.nextDouble();
		if(valoreSerra < 5)
		{
			System.out.println("Stato della serra: Danni Irreparabili!!!");
		}
		else if (valoreSerra < 10)
		{
			System.out.println("Stato della serra: Situazione di Pericolo");
		}
		else
		{
			System.out.println("Stato della serra: Valori Normali");
		}

	}

}
