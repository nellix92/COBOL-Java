package esercizi.gg5.ArcoNoe;

public class Main {

	  public static void main(String[] args) {
	        Arca arca = new Arca();
	        Cane cane1 = new Cane();
	        Canarino canarino1 = new Canarino();


	        arca.salva(cane1);
	        arca.salva(canarino1);

	        System.out.println("Numero di animali nell'arca: " + arca.getNumeroAnimali());
	        System.out.println("Coro degli animali: " + arca.coro());
	        System.out.println("Descrizione dell'arca:\n" + arca.toString());
	    }
	}

