package esercizi.gg2;

import java.util.Date;
import java.util.Scanner;

public class ConversioneData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

        System.out.print("Inserisci una data (GG/MM/AAAA): ");
        String input = s.nextLine();

        String[] divided = input.split("/");

        int giorno = Integer.parseInt(divided[0]);
        int mese = Integer.parseInt(divided[1]);
        int anno = Integer.parseInt(divided[2]);

        String[] mesi = {
            "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno",
            "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"
        };

        String meseTestuale = mesi[mese - 1];

        System.out.println(giorno + " " + meseTestuale + " " + anno);

	}

}
