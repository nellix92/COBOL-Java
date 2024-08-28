package gestioneDipendenti;

import java.util.Date;

public class Manager extends Impiegato {

	private String segretaria;

	public Manager(String nome, double salario, Date dataAssunzione, String segretaria) {
		super(nome, salario, dataAssunzione);   // chiama il costruttore di Impiegato
		this.setSegretaria(segretaria);
	}

	// costruttore che pone dataAssunzione = data odierna
	public Manager(String nome, double salario, String segretaria) {
		super(nome, salario);  // imposta data odierna
		this.setSegretaria(segretaria);
	}

	// costruttore che pone salario iniziale a 2000
	public Manager(String nome, Date dataAssunzione, String segretaria) {
		super(nome,2000, dataAssunzione);
		this.setSegretaria(segretaria);
	}

	public String getSegretaria() {
		return segretaria;
	}

	public void setSegretaria(String segretaria) {
		this.segretaria = segretaria;
	}

	@Override
	public String toString() {
		return "Manager >> " + super.toString() + ", segretaria=" + segretaria;
	}

	@Override
	public void incrSalario(double aumento) {
		// calcolo del bonus in funzione degli anni di anzianità
		Date odierna = new Date();
		double bonus = 0.5*(odierna.getYear() +1900 - super.getAnnoAssunzione());
		super.incrSalario(aumento + bonus);
		
	}

	

	
	
	
}
