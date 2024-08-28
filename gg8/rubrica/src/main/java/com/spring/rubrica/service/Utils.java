package com.spring.rubrica.service;


import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

public class Utils {
    public static Rubrica convert(RubricaDTO entity){
        return new Rubrica(entity.getIdRubrica(),entity.getNomeproprietario(),entity.getAnnodiCreazione());
    }
    public static RubricaDTO convert(Rubrica entity){
        return new RubricaDTO(entity.getIdRubrica(),entity.getNomeproprietario(),entity.getAnnodiCreazione());
    }

    public static ContattoDTO convert(Contatto entity){
        return new ContattoDTO(entity.getIdContatto(),
                entity.getNome(),entity.getCognome(),
                entity.getNumero(),entity.getGruppDiAppartenenza(),
                entity.getDataDiNascita(),entity.isPreferito());
    }

    public static Contatto convert(ContattoDTO entity){
        return new Contatto(entity.getIdContatto(),
                entity.getNome(),entity.getCognome(),
                entity.getNumero(),entity.getGruppDiAppartenenza(),
                entity.getDataDiNascita(),entity.isPreferito());
    }


}
