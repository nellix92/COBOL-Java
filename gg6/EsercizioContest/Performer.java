package Esercizi.EsercizioContest;

import java.util.ArrayList;
import java.util.Objects;

public class Performer {
    String nome;
    int voti;

    public Performer(String nome ){
        this.nome = nome;
        this.voti = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Performer performer)) return false;
        return nome.equalsIgnoreCase(performer.nome);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    public void addVoto(){
        this.voti++;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "nome='" + nome + '\'' +
                ", voti=" + voti +
                '}';
    }
}
