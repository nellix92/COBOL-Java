package esercizi.gg3;

public class Carta implements Comparable<Carta> {
    private final int valore;
    private final int seme;

    public Carta(int valore, int seme) {
        this.valore = valore;
        this.seme = seme;
    }

    public int getValore() {
        return valore;
    }

    public int getSeme() {
        return seme;
    }

    @Override
    public String toString() {
        String[] semi = {"Denari", "Coppe", "Spade", "Bastoni"};
        return valore + " di " + semi[seme];
    }

    @Override
    public int compareTo(Carta altraCarta) {
        if (this.valore > altraCarta.valore) {
            return 1;
        } else if (this.valore < altraCarta.valore) {
            return -1;
        } else {
            // In caso di valori uguali, confrontiamo i semi
            return Integer.compare(this.seme, altraCarta.seme);
        }
    }
}
