package com.spring.rubrica.dto;

import java.util.Date;

public class ContattoDTO {
    private int idContatto;
    private String nome;
    private String cognome;
    private String numero;
    private String gruppDiAppartenenza;
    private String dataDiNascita;
    private boolean preferito;

    public void setIdContatto(int idContatto) {
        this.idContatto = idContatto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setGruppDiAppartenenza(String gruppDiAppartenenza) {
        this.gruppDiAppartenenza = gruppDiAppartenenza;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setPreferito(boolean preferito) {
        this.preferito = preferito;
    }

    public ContattoDTO(int idContatto, String nome, String cognome, String numero, String gruppDiAppartenenza, String dataDiNascita, boolean preferito) {
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