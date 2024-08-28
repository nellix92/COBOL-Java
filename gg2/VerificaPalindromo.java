package esercizi.gg2;
import java.util.Scanner;

public class VerificaPalindromo {

    public static void main(String[] args) {
    	boolean isContinue=true;
    	String end;
    	while(isContinue)
    	{
    		Scanner scanner = new Scanner(System.in);

    		System.out.print("Inserisci una stringa: ");
    		String input = scanner.nextLine();

    		String inverted = new StringBuilder(input).reverse().toString();

    		if (input.equals(inverted)) {
    			System.out.println(input + " è palindromo");
    		} else {
    			System.out.println(input + " non è palindromo");
    		}
    		System.out.println("Vuoi coninuare? [Y/N]");
    		end = scanner.nextLine().toUpperCase();
    		if(end.equals("N"))
    		{
    			isContinue = false;
    		}
        
    	}

    }
}
