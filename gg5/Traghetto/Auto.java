package esercizi.gg5.Traghetto;

public class Auto extends Veicolo {
	
    public enum Tipo { MINI, STANDARD, SUV }

    private Tipo tipo;

    public Auto(String targa, int numeroPasseggeri, Tipo tipo) {
        super(targa, numeroPasseggeri);
        this.tipo = tipo;
    }

    @Override
    public double calcolaTariffa() {
        double tariffaBase;
        switch (tipo) {
            case MINI:
                tariffaBase = 4;
                break;
            case STANDARD:
                tariffaBase = 5;
                break;
            case SUV:
                tariffaBase = 8.5;
                break;
            default:
                throw new IllegalArgumentException("Tipo di auto non valido.");
        }
        return tariffaBase + calcolaTariffaPasseggeri();
    }

}
