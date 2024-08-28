package esercizi.gg3;

public class Contatto {

	private String nome;
	private String cognome;
	private int numero;
	
	
	public Contatto(String nome, String cognome, int numero) {
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
	}
	


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	@Override
	public String toString() {
		return "nome=" + nome + ", cognome=" + cognome + ", numero=" + numero;
	}


}
