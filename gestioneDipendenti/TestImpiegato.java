package gestioneDipendenti;

import java.util.Date;

public class TestImpiegato {

	public static void main(String[] args) {
		Date d = new Date(110, 2, 5) ;
		Impiegato imp1 = new Impiegato("mario", 1000, d);
		
		System.out.println(imp1.getNome());
		System.out.println(imp1.getSalario());
		System.out.println(imp1.getDataAssunzione());
		
		System.out.println("-------------------------------");
		
		Impiegato imp2 = new Impiegato("anna", 1200);
		System.out.println(imp2.getNome());
		System.out.println(imp2.getSalario());
		System.out.println(imp2.getDataAssunzione());
		
		System.out.println("-------------------------------");
		
		Impiegato imp3 = new Impiegato("giorgio", d);
		System.out.println(imp3.getNome());
		System.out.println(imp3.getSalario());
		System.out.println(imp3.getDataAssunzione());
		
		System.out.println("-------------------------------");
		
		Impiegato imp4 = new Impiegato("giulia");
		System.out.println(imp4.getNome());
		System.out.println(imp4.getSalario());
		System.out.println(imp4.getDataAssunzione());
		
		System.out.println(imp4.toString());
		System.out.println(imp4);  // chiama in automatico il metodo toString
		
		System.out.println("-------------------------------");
		
		//Impiegato i = new Impiegato(); NOn ho il costruttore di default
		
		// test dei metodi getter/setter e altri...
		System.out.println(imp4.getNome());
		System.out.println(imp4.getSalario());
		System.out.println(imp4.getDataAssunzione());
		System.out.println(imp4.getAnnoAssunzione());
		
		imp4.setSalario(1700);
		System.out.println("dopo l'aumento..." + imp4);
		
		imp4.incrSalario(50);  // mi aspetto salario = 1750
		System.out.println("infine... " + imp4);
		
		// cose da NON fare
//		imp1.nome = "oueqrbnqèoeb";
//		System.out.println(imp1);
		
		imp1.incrSalario(100);
		System.out.println(imp1);
		
		System.out.println("---------- uso i manager -------------");
		Manager man1 = new Manager("man1", 2100, "segre1");
		Manager man2 = new Manager("man2", 2200, new Date(114,4,4) , "segre2");
		Manager man3 = new Manager("man3", new Date(104,4,4) , "segre3");
		
		System.out.println(man1);
		System.out.println(man2);
		System.out.println(man3);
		
		man1.incrSalario(100);  // bonus = 0
		man2.incrSalario(100);	// bonus = 5
		man3.incrSalario(100);	// bonus = 10
		
		System.out.println("aumento di 100 euro x tutti");
		
		System.out.println(man1);
		System.out.println(man2);
		System.out.println(man3);
		
		
		System.out.println("------------ creo l'azienda --------------------");
		
		Azienda azienda = new Azienda("accenture");
		System.out.println(azienda);
		
		azienda.assume(imp4);
		azienda.assume(man3);
		azienda.assume(imp3);
		azienda.assume(man2);
		
		System.out.println(azienda);
		
	}

}