package com.spring.rubrica.entity;

import java.util.Date;

public class Contatto {
    private int idContatto;
    private String nome;
    private String cognome;
    private String numero;
    private String gruppDiAppartenenza;
    private String dataDiNascita;
    private boolean preferito;

    public Contatto(){}

    public Contatto(int idContatto, String nome, String cognome, String numero, String gruppDiAppartenenza, String dataDiNascita) {
        this.idContatto = idContatto;
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.gruppDiAppartenenza = gruppDiAppartenenza;
        this.dataDiNascita = dataDiNascita;
        this.preferito = false;
    }

    public Contatto(int idContatto, String nome, String cognome, String numero, String gruppDiAppartenenza, String dataDiNascita,boolean preferito) {
        this.idContatto = idContatto;
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.gruppDiAppartenenza = gruppDiAppartenenza;
        this.dataDiNascita = dataDiNascita;
        this.preferito = preferito;
    }

    public int getIdContatto() {
        return idContatto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero() {
        return numero;
    }

    public String getGruppDiAppartenenza() {
        return gruppDiAppartenenza;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public boolean isPreferito() {
        return preferito;
    }
}