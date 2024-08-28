package esercizi.gg1;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Benvenuto nell'app che ti confronta l'area di due rettangoli");
		Scanner scanner = new Scanner (System.in);
		System.out.println("Inserisci un valore intero per la base: ");
		int base1 = scanner.nextInt();
		System.out.println("Inserisci un valore intero per l'altezza:");
		int altezza1 = scanner.nextInt();
		int area1 = base1 * altezza1;
		System.out.println("Inserisci un valore intero per la base:");
		int base2 = scanner.nextInt();
		System.out.println("Inserisci un valore intero per l'altezza:");
		int altezza2 = scanner.nextInt();
		int area2 = base2 * altezza2;
		if(area1 > area2) 
		{
			System.out.println("L'area "+area1 +" del primo rettangolo "+"è maggiore dell'area "+area2+" del secondo rettangolo");
			
		}
		else if(area1 < area2) {
			
			System.out.println("L'area "+area1 +" del primo rettangolo "+"è minore dell'area "+area2+" del secondo rettangolo");
			
		}
		else {
			
			System.out.println("L'area "+area1 +" del primo rettangolo "+"è uguale all'area "+area2+" del secondo rettangolo");
		}
		
	}
}
