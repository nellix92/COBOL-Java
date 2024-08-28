package esercizi.gg5.Traghetto;

public class Moto extends Veicolo {
	
    public Moto(String targa, int numeroPasseggeri) {
        super(targa, numeroPasseggeri);
        if (numeroPasseggeri > 2) {
            throw new IllegalArgumentException("Una moto può avere al massimo 2 passeggeri.");
        }
    }

    @Override
    public double calcolaTariffa() {
        return 3.5 + calcolaTariffaPasseggeri();
    }
}
