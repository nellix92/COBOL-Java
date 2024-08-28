package esercizi.gg5.ArcoNoe;

public class Cane extends Terrestre {

	@Override
	public String verso() {
		return "bau-bau";
	}

	@Override
	public String toString() {
		return "Cane " + "fa parte della categoria: "+categoria();
	}
	
	

}
