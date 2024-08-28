package com.spring.utenti.entity;

import java.time.LocalDateTime;


public class Utente {
    private int idUtente;
    private String mail;

    public Utente(int idUtente, String mail){
        this.idUtente = idUtente;
        this.mail=mail;

    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getMail() {
        return mail;
    }


}
