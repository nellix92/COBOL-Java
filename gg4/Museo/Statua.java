package esercizi.gg4.Museo;

public class Statua extends Opera {
	
	private String materiale;
	private double altezza;
	
	

	

	@Override
	public String toString() {
		return super.toString() + " Statua [materiale=" + materiale + ", altezza=" + altezza + "]";
	}


	public String getMateriale() {
		return materiale;
	}



	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}



	public double getAltezza() {
		return altezza;
	}



	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}



	public Statua(String autore, String titolo , String materiale, double altezza) {
		super(titolo, autore);
        this.materiale = materiale;
        this.altezza = altezza;
	}
	
	

}
