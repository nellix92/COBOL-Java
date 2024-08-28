package oggetti;

import java.util.Date;

public class EsempioDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d = new Date();
		System.out.println(d);
		
		int mese = d.getMonth(); //parte da 0 la conta del mese
		System.out.println(mese);
		
		int meseCOrretto = d.getMonth()+1;
		System.out.println(meseCOrretto);
		
		int giornoSettimana = d.getDay();
		System.out.println(giornoSettimana);
		
		//modifica stato dell'oggetto
		d.setMonth(11);
		System.out.println(d);
	}

}
