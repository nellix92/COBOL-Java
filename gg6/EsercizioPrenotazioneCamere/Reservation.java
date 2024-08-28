package Esercizi.EsercizioPrenotazioneCamere;

import java.util.Objects;

public class Reservation {

    String nome;
    int dataDiInizio;
    int dataDiFine;
    int numerodiStanza;

    public Reservation(String nome,int dataDiInizio,int dataDiFine,int numerodiStanza){
        this.nome = nome;
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
        this.numerodiStanza = numerodiStanza;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return (numerodiStanza == that.numerodiStanza) &&
                (dataDiInizio<that.dataDiInizio && that.dataDiInizio<dataDiFine) &&
                (dataDiInizio<=that.dataDiFine && that.dataDiFine>=dataDiFine);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numerodiStanza);
    }
}
