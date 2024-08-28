package esercizi.gg1;

import java.util.Scanner;

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inserisci un numero k:");
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		System.out.println("Inserisci un numero N:");
		int number2 = s.nextInt();
		System.out.println(number+" elevato a "+number2+" : "+ Math.pow(number, number2));


	}

}
