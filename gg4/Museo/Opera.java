package esercizi.gg4.Museo;

public class Opera {
	private String autore;
	private String titolo;
	private boolean esposta;
	
	
	public Opera(String autore, String titolo) {
		this.autore = autore;
		this.titolo = titolo;
		this.esposta = false;
	}
	
	public void Esponi() {
		this.esposta = true;
	}
	
	public void Riponi () {
		this.esposta = false;
	}
	
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public boolean isEsposta() {
		return esposta;
	}
	public void setEsposta(boolean esposta) {
		this.esposta = esposta;
	}
	@Override
	public String toString() {
		return "Autore: " + this.autore + " , Titolo: " + this.titolo + "\n";
	}

	
	
}
