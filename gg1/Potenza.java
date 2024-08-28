package esercizi.gg1;

import java.util.Scanner;

public class Potenza{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number1;
		int number2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insersci il primo numero intero:");
		number1 = scanner.nextInt();
		System.out.println("insersco il secondo numero intero:");
		number2 = scanner.nextInt();
		if(number1 == number2*number2)
		{
			System.out.println("il primo numero "+number1+" è il quadrato di "+number2);
		}
		else
		{
			System.out.println("il primo numero "+number1+" non è il quadrato di "+number2);
		}
				
	}

}
