package gestioneDipendenti;

import java.util.ArrayList;
import java.util.Date;

public class Azienda {
	
	private String nome;
	private int capitaleSociale;
	private ArrayList<Impiegato> elencoDipendenti = new ArrayList <> ();
	
	public Azienda(String nome, int capitaleSociale) {
		this.nome = nome;
		this.capitaleSociale = capitaleSociale;
	}
	
	public Azienda(String nome) {
		this.nome = nome;
		this.capitaleSociale = 10000000;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCapitaleSociale() {
		return capitaleSociale;
	}
	
	public void setCapitaleSociale(int capitaleSociale) {
		this.capitaleSociale = capitaleSociale;
	}
	
	public ArrayList<Impiegato> getElencoDipendenti() {
		return elencoDipendenti;
	}
	
	@Override
	public String toString() {
       String s = "Azienda: "+this.nome+" , capitale sociale: "+this.capitaleSociale+ "\n";
       for (Impiegato impiegato : elencoDipendenti) {
    	   s = s + impiegato.toString() + "\n";	
	}
       return s;
	}
	
	
	// metodi operativi
	
	public void assume (Impiegato i) {
		this.elencoDipendenti.add(i);
	}
	
	
	

}
