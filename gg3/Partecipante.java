package esercizi.gg3;

public class Partecipante {
    private String nome;
    private Carta cartaInMano;
    private int punteggio;

    public Partecipante(String nome) {
        this.nome = nome;
        this.punteggio = 0;
    }

    public Partecipante(String nome, int punteggio) {
        this.nome = nome;
        this.punteggio = punteggio;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", cartaInMano=" + cartaInMano +
                ", punteggio=" + punteggio +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carta getCartaInMano() {
        return cartaInMano;
    }

    public void prende(Carta cartaInMano) {
        this.cartaInMano = cartaInMano;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void incrementaPunteggio() {
        this.punteggio++;
    }

    public void incrementaPunteggio(int incremento) {
        this.punteggio += incremento;
    }
}

