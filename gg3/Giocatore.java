package esercizi.gg3;

public class Giocatore {
    private String nome;
    private int budget;
    private int puntataCorrente;
    private int numeroGiocato;
    private static final int RICARICO = 5;

    public Giocatore(String nome, int budgetIniziale) {
        this.nome = nome;
        this.budget = budgetIniziale;
        this.puntataCorrente = 0;
        this.numeroGiocato = 0;
    }

    public void punta(int puntata, int numero) {
        if (puntata <= this.budget) {
            this.puntataCorrente = puntata;
            this.numeroGiocato = numero;
            this.budget -= puntata;
        }
    }

    public void incassa() {
        this.budget += this.puntataCorrente * RICARICO;
    }

    public void reset() {
        this.puntataCorrente = 0;
        this.numeroGiocato = 0;
    }

    public void recuperaPuntata() {
        this.budget += this.puntataCorrente;
    }

    public int getBudget() {
        return this.budget;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPuntata() {
        return this.puntataCorrente;
    }

    public int getNumeroGiocato() {
        return this.numeroGiocato;
    }
}


