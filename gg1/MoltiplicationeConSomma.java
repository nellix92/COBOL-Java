package esercizi.gg1;
import java.util.Scanner;

public class MoltiplicationeConSomma {

	public static void main(String[] args) {
		// TMoltiplicazione N x M = sommo N a se stesso M volte
		
		System.out.println("Inserisci un primo numero:");
		Scanner s = new Scanner (System.in);
		int number1 = s.nextInt();
		System.out.println("Inserisci un secondo numero:");
		int number2 = s.nextInt();
		int risultato = 0;
		for (int i=0; i< number2; i++ )
		{
			risultato += number1;
		}
		System.out.println("Il risultato sarà:\n"+risultato);
		
		
	}

}
