package com.spring.rubrica.dto;

import com.spring.rubrica.entity.Contatto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RubricaDTO {
    private int idRubrica;
    private String nomeproprietario;
    private int annodiCreazione;


    public RubricaDTO() {
    }

    public RubricaDTO(int idRubrica, String nomeproprietario, int annodiCreazione) {
        this.idRubrica = idRubrica;
        this.nomeproprietario = nomeproprietario;
        this.annodiCreazione = annodiCreazione;

    }

    public int getIdRubrica() {
        return idRubrica;
    }


    //Setters and getters
    public void setIdRubrica(int idRubrica) {
        this.idRubrica = idRubrica;
    }


    public void setNomeproprietario(String nomeproprietario) {
        this.nomeproprietario = nomeproprietario;
    }

    public void setAnnodiCreazione(int annodiCreazione) {
        this.annodiCreazione = annodiCreazione;
    }

    public String getNomeproprietario() {
        return nomeproprietario;
    }

    public int getAnnodiCreazione() {
        return annodiCreazione;
    }



}