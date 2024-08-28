package esercizi.gg2;

import java.util.Scanner;

public class StringaNumerica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci una stringa:");
		String s1 = s.nextLine();
		boolean isNumber = true;
		for (int i = 0; i < s1.length(); i++)
		{
			char c = s1.charAt(i);
			if (!Character.isDigit(c))
			{
				isNumber = false;
				break;
			}
			
		}
		if (isNumber)
		{
			System.out.println(s1+" è un testo numerico");
		}else {
			System.out.println(s1+" è un testo alfanumerico");
		}

	}
}
