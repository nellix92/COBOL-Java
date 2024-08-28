package com.spring.rubrica.service;

import com.spring.rubrica.dao.DAORubrica;
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;


public class RubricaService {

    DAORubrica daoRubrica;


    private static RubricaService instance=  null;

    public static RubricaService getInstance() {
        if(instance == null)
            return new RubricaService();
        return instance;
    }

    private RubricaService(){
        this.daoRubrica = DAORubrica.getInstance();
    }

    public void insertRubrica(RubricaDTO rubrica) {
        System.out.println(Utils.convert(rubrica).getNomeproprietario());
        daoRubrica.insertRubrica(Utils.convert(rubrica));
    }

    public RubricaDTO getRubrica(int idRubrica) {
        return Utils.convert(daoRubrica.getRubrica(idRubrica));
    }


    public boolean removeRubrica(int idRubrica) {
        return daoRubrica.removeRubrica(idRubrica);
    }


    public List<RubricaDTO> getRubriche() {
        return daoRubrica.getRubriche().stream().map(Utils::convert).toList();
    }

    public List<ContattoDTO> getContatti(int idRubrica) {
        return daoRubrica.getContatti(idRubrica).stream().map(Utils::convert).toList();
    }

    public void inserisciContatto(int idRubrica,ContattoDTO contattoDTO){
        daoRubrica.getRubrica(idRubrica).inserisciContatto(Utils.convert(contattoDTO));
    }

    public void updateContatto(int idRubrica,ContattoDTO contatto){
        daoRubrica.getRubrica(idRubrica).updateContatto(Utils.convert(contatto));
    }

    public List<String> selectNumeroContatti(int idRubrica){
        return daoRubrica.getRubrica(idRubrica).selectNumeroContatti();
    }









    public void deleteExistingContato(int idRubrica,ContattoDTO contatto){
      daoRubrica.getRubrica(idRubrica).deleteExistingContatto(Utils.convert(contatto));
    }


    public ContattoDTO searchContatto(int idRubrica,int idContatto){
        return Utils.convert(daoRubrica.getRubrica(idRubrica).searchContatto(idContatto));
    }


    public  List<ContattoDTO> searchContatto(int idRubrica,String numero){

        return daoRubrica.getRubrica(idRubrica).searchContatto(numero).stream().map(Utils::convert).toList();
    }


    public  List<ContattoDTO> searchContatto(int idRubrica,String nome,String cognome){
        return daoRubrica.getRubrica(idRubrica).searchContatto(nome,cognome).stream().map(Utils::convert).toList();

    }

    public  List<ContattoDTO> searchContattiPreferiti(int idRubrica){
        return daoRubrica.getRubrica(idRubrica).searchContattiPreferiti().stream().map(Utils::convert).toList();

    }



}
