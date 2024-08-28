package esercizi.gg1;

import java.util.Scanner;

public class ConversioneTemperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner (System.in);
		String continua = "Y";
	    while (continua.equals("Y")) {
		System.out.println("Che tipo di conversione vuoi fare? [F]Celsius---->Farenhait, [C]Farenhait---->Celsius");
		String choice = s.nextLine().toUpperCase();
		switch(choice)
		{
		case "F":
			System.out.println("Inserisci il valore dei gradi Celsius:");
			double temperaturaIn = s.nextDouble();
			s.nextLine();
			double tempeaturaOut = (temperaturaIn * 9/5) + 32; 
			System.out.println("La temperatura in Farenhait è:\n"+tempeaturaOut);
			break;
		case "C":
			System.out.println("Inserisci il valore dei gradi Farenhait:");
			temperaturaIn = s.nextDouble();
			s.nextLine();
			tempeaturaOut = (temperaturaIn - 32) + 5/9; 
			System.out.println("Latemperatura in Celsius è:\n"+tempeaturaOut);
			break;
		default:
			System.out.println("Scelta non valida!!!");
			break;
		}
		System.out.println("Vuoi continuare? [Y/N]");
		continua = s.nextLine().toUpperCase();
		
	    }
	    s.close();
	   
	}

}
