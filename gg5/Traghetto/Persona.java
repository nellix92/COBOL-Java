package esercizi.gg5.Traghetto;

public class Persona implements Tariffa {
    private String nome;
    private String cognome;
    private static final double TARIFFA_PERSONA = 2.5;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public double calcolaTariffa() {
        return TARIFFA_PERSONA;
    }
}
