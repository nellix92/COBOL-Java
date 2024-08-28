package esercizi.gg3;

public class Casino {
    private String nome;
    private int capitale;
    private static final int RICARICO = 5;

    public Casino(String nome, int capitaleIniziale) {
        this.nome = nome;
        this.capitale = capitaleIniziale;
    }

    public boolean valutaPuntate(int[] puntate) {
        int totalePuntate = 0;
        for (int puntata : puntate) {
            totalePuntate += puntata;
        }
        return this.capitale >= totalePuntate * RICARICO;
    }

    public void incassa(int importo) {
        this.capitale += importo;
    }

    public void paga(int importo) {
        this.capitale -= importo * RICARICO;
    }

    public int getCapitale() {
        return this.capitale;
    }
}


