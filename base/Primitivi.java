package base;

public class Primitivi {

	public static void main(String[] args) {
		// Esempio sui tipi interi
		
		int number1 = 10;	
		byte b = 50;
		
		// esempio sui char
		
		char carattere = 'N';
		
		// esempio tipo logico
		
		boolean flag = true;
		
		//operazione tra i numeri
		int somma = number1 + b;
		System.out.println("La somma è: "+somma);
		
		double d = 2.3456;
		int sum = (int) (number1 + d); // cast: mi somma i due elementi e poi me lo tronca senza approx facendolo diventare un intero
		System.out.println("la somma è: "+sum);
		
		// casting inappropriato
		
		byte n1= 100;
		byte n2 = 100;
		//siccome il range di byte va da -127 a +127 n1 + n2 fa + 200 quindi sfora il range di byte
		int s1 = n1 + n2;
		//oppure
		double s2 = (byte) (n1 + n2);
		
		
		
		

	}

}
