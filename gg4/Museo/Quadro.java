package esercizi.gg4.Museo;

public class Quadro extends Opera {
	
	private String tecnicaUsata;
	
	
	public String getTecnicaUsata() {
		return tecnicaUsata;
	}
	
	
	
	public void setTecnicaUsata(String tecnicaUsata) {
		this.tecnicaUsata = tecnicaUsata;
	}
	
		
	
	public Quadro(String autore, String titolo, String tecnicaUsata) {
		super(autore, titolo);
		this.tecnicaUsata = tecnicaUsata;
	}


	@Override
	public String toString() {
		return super.toString() + "tecnica usata: "+tecnicaUsata;
	}
	

	

} 






