package com.spring.progetto.entities;


import java.util.Date;

// Qui non ci sono annotazioni -> Spring non crea questa classe
public class Studente {

    private int matricola;
    private String nome;
    private String cognome;
    public Date dataDiNascita;

    public Studente(){

    }


    public Studente(Date dataDiNascita, String cognome, String nome, int matricola) {
        this.dataDiNascita = dataDiNascita;
        this.cognome = cognome;
        this.nome = nome;
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
