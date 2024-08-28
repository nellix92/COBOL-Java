package esercizi.gg2;

import java.util.Date;
import java.util.Scanner;

public class DifferenzaDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Date now = new Date ();
		Date endLesson = new Date ();
		endLesson.setHours(18);
		endLesson.setMinutes(0);
		endLesson.setSeconds(0);
		long differenzaOra = (endLesson.getTime() - now.getTime())/(1000*60);
		if (differenzaOra > 0)
		{
			System.out.println("I minuti che mancano alla fine della lezione sono: "+differenzaOra+" min");
		}
		else 
		{
			System.out.println("La lezione è già terminata");
		}

		setOra(now,endLesson);
		
	}
	
	public static void setOra(Date now, Date end) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Inserisci l'ora della fine della lezione ");
		int ora = scanner.nextInt();
		end.setHours(ora);
		long differenzaOra = (end.getTime() - now.getTime())/(1000*60);
		if (differenzaOra > 0)
		{
			System.out.println("I minuti che mancano alla fine della lezione sono: "+differenzaOra+" min");
		}
		else 
		{
			System.out.println("La lezione è già terminata");
		}
	}

}
