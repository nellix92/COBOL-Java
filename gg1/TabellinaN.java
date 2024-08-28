package esercizi.gg1;

import java.util.Scanner;

public class TabellinaN {
	public static void main(String[] args) {
		String isContinue = "Y";
		while(isContinue.equals("Y"))
		{
		System.out.println("Inserisci un numero compreso tra 1 a 10");
		Scanner s = new Scanner (System.in);
		int number = s.nextInt();
		s.nextLine();
		System.out.println("La tabellina di "+number+" è:\n");
		for (int i = 0;i<=10;i++)
		{
			int number2 = number * i;
			System.out.println(i+1+" ) "+number+" * "+i+" = "+number2);
		}
		System.out.println("Vuoi continuare? [Y/N]");
		isContinue = s.nextLine().toUpperCase();
		}
	}

}
