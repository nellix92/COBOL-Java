package gestioneDipendenti;

import java.util.Date;

public class Impiegato {
	
	// 1. dichiarazione attributi
	private String nome;
	private double salario;
	private Date dataAssunzione;


	// 2. metodi -> costruttore/i
	public Impiegato(String nome, double salario, Date dataAssunzione) {
		this.nome = nome;
		this.salario = salario;
		this.dataAssunzione = dataAssunzione;
	}
	
	// questo costruttore imposta la data assunzione alla data corrente
	public Impiegato(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
		this.dataAssunzione = new Date();  // data attuale
	}	
	
	// costruttore che imposta il salario 'iniziale' a 1500 (valore noto)
	public Impiegato(String nome, Date dataAssunzione) {
		this.nome = nome;
		this.salario = 1500;
		this.dataAssunzione = dataAssunzione;
	}

	// data odierna e salario a 1500
	public Impiegato(String nome) {
		this.nome = nome;
		this.salario = 1500;
		this.dataAssunzione = new Date();
	}

	// 3. metodi getters -> metodi di lettura
	
	
	// 4. metodi setters -> metodi di modifica
	


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario > 0)
			this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}
	
	public int getAnnoAssunzione() {
		int anno = this.dataAssunzione.getYear() + 1900;
		return anno;
	}
	
	// 5. metodo di formattazione
	@Override
	public String toString() {
		return "Nome=" + this.nome + ", salario=" + this.salario + ", dataAssunzione=" + this.dataAssunzione;
	}
	
	
	// 6. altri metodi operativi
	public void incrSalario(double aumento) {
		if(aumento > 0)
			this.salario = salario + aumento;
	}

	
}
