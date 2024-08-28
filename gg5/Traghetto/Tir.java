package esercizi.gg5.Traghetto;

public class Tir extends Veicolo {

    private double tonnellateMerce;
    private static final double TARIFFA_TIR = 12.5;
    private static final double TARIFFA_MERCE = 0.5;

    public Tir(String targa, int numeroPasseggeri, double tonnellateMerce) {
        super(targa, numeroPasseggeri);
        this.tonnellateMerce = tonnellateMerce;
    }

    @Override
    public double calcolaTariffa() {
        return TARIFFA_TIR + calcolaTariffaPasseggeri() + (tonnellateMerce * TARIFFA_MERCE);
    }

}
