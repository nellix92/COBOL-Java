package esercizi.gg5.Traghetto;

import java.util.ArrayList;

public class Biglietteria {

    private double cassa;
    private ArrayList<Tariffa> coda;

    public Biglietteria() {
        this.cassa = 0;
        this.coda = new ArrayList<>();
    }

    public void aggiungiInCoda(Tariffa t) {
        coda.add(t);
    }

    public Tariffa riceviPagamento() {
        if (coda.isEmpty()) {
            throw new IllegalStateException("La coda è vuota.");
        }
        Tariffa t = coda.remove(0);
        double tariffa = t.calcolaTariffa();
        cassa += tariffa;
        return t;
    }

    public double getCassa() {
        return cassa;
    }
}
