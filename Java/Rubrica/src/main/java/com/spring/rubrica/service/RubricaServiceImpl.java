package com.spring.rubrica.service;

import com.spring.rubrica.dao.DAORubrica; 
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService{

	@Autowired
    DAORubrica daoRubrica;


    public void insertRubrica(RubricaDTO rubrica) {
        System.out.println(Converter.convert(rubrica).getNomeproprietario());
        daoRubrica.insertRubrica(Converter.convert(rubrica));
    }

    public RubricaDTO getRubrica(int idRubrica) {
        return Converter.convert(daoRubrica.getRubrica(idRubrica));
    }


    public boolean removeRubrica(int idRubrica) {
        return daoRubrica.removeRubrica(idRubrica);
    }


    public List<RubricaDTO> getRubriche() {
        return daoRubrica.getRubriche().stream().map(Converter::convert).toList();
    }

    public List<ContattoDTO> getContatti(int idRubrica) {
        return daoRubrica.getContatti(idRubrica).stream().map(Converter::convert).toList();
    }

    @Override
    public void updateRubricaNome(int idRubrica,String nomeProprietrario) {
        daoRubrica.getRubrica(idRubrica).setNomeproprietario(nomeProprietrario);
    }    

    public void inserisciContatto(int idRubrica,ContattoDTO contattoDTO){
        daoRubrica.getRubrica(idRubrica).inserisciContatto(Converter.convert(contattoDTO));
    }

    public void updateContatto(int idRubrica,ContattoDTO contatto){
        daoRubrica.getRubrica(idRubrica).updateContatto(Converter.convert(contatto));
    }

    public List<String> selectNumeroContatti(int idRubrica){
        return daoRubrica.getRubrica(idRubrica).selectNumeroContatti();
    }


    public void deleteExistingContato(int idRubrica,ContattoDTO contatto){
      daoRubrica.getRubrica(idRubrica).deleteExistingContatto(Converter.convert(contatto));
    }


    public ContattoDTO searchContatto(int idRubrica,int idContatto){
        return Converter.convert(daoRubrica.getRubrica(idRubrica).searchContatto(idContatto));
    }


    public  List<ContattoDTO> searchContatto(int idRubrica,String numero){

        return daoRubrica.getRubrica(idRubrica).searchContatto(numero).stream().map(Converter::convert).toList();
    }


    public  List<ContattoDTO> searchContatto(int idRubrica,String nome,String cognome){
        return daoRubrica.getRubrica(idRubrica).searchContatto(nome,cognome).stream().map(Converter::convert).toList();

    }

    public  List<ContattoDTO> searchContattiPreferiti(int idRubrica){
        return daoRubrica.getRubrica(idRubrica).searchContattiPreferiti().stream().map(Converter::convert).toList();

    }



}