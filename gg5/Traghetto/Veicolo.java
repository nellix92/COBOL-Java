package esercizi.gg5.Traghetto;

public abstract class Veicolo implements Tariffa {
    private String targa;
    private int numeroPasseggeri;

    public Veicolo(String targa, int numeroPasseggeri) {
        if (numeroPasseggeri < 1) {
            throw new IllegalArgumentException("Un veicolo deve avere almeno un passeggero.");
        }
        this.targa = targa;
        this.numeroPasseggeri = numeroPasseggeri;
    }

    protected int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    protected double calcolaTariffaPasseggeri() {
        return numeroPasseggeri * 2.5;
    }

}
