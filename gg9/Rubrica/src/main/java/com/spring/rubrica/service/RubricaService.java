package com.spring.rubrica.service;

import java.util.List;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;

public interface RubricaService {
	
    void insertRubrica(RubricaDTO rubrica);

    RubricaDTO getRubrica(int idRubrica);


    boolean removeRubrica(int idRubrica);

    List<RubricaDTO> getRubriche();
    
    void updateRubricaNome(int idRubrica,String nomeProprietrario);

    List<ContattoDTO> getContatti(int idRubrica);
    
    void inserisciContatto(int idRubrica,ContattoDTO contattoDTO);

    void updateContatto(int idRubrica,ContattoDTO contatto);

    List<String> selectNumeroContatti(int idRubrica);

    void deleteExistingContato(int idRubrica,ContattoDTO contatto);


    ContattoDTO searchContatto(int idRubrica,int idContatto);


    List<ContattoDTO> searchContatto(int idRubrica,String numero);

    List<ContattoDTO> searchContatto(int idRubrica,String nome,String cognome);

    List<ContattoDTO> searchContattiPreferiti(int idRubrica);
}
