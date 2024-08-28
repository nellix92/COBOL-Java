package com.spring.rubrica.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rubrica {
    private int idRubrica;
    private Map<Integer,Contatto> contatti;
    private String nomeproprietario;
    private int annodiCreazione;


    public Rubrica() {
    }

    public Rubrica(int idRubrica, String nomeproprietario, int annodiCreazione) {
        this.idRubrica = idRubrica;
        this.nomeproprietario = nomeproprietario;
        this.annodiCreazione = annodiCreazione;
        this.contatti = new HashMap<>();
    }

    public int getIdRubrica() {
        return idRubrica;
    }

    public List<Contatto> getContatti() {
        return new ArrayList<>(contatti.values());
    }

    public void updateContatto(Contatto contatto){
        if(!contatti.containsKey(contatto.getIdContatto())) throw new RuntimeException("Contatto non esiste nella rubrica.");
        contatti.remove(contatto.getIdContatto());
        contatti.put(contatto.getIdContatto(),contatto);
    }


    public List<Contatto> selectAll(){
        return new ArrayList<>(contatti.values());
    }

    public List<String> selectNumeroContatti(){
        return contatti.values().stream().map(Contatto::getNumero).toList();
    }
    public void deleteExistingContatto(Contatto contatto){
        if(!contatti.containsKey(contatto.getIdContatto())) throw new RuntimeException("Contatto non esiste nella rubrica.");
        contatti.remove(contatto.getIdContatto());

    }

    public Contatto searchContatto(int idContatto){
        if(!contatti.containsKey(idContatto)) throw new RuntimeException("Contatto non esiste nella rubrica.");
        return contatti.get(idContatto);

    }

    public  List<Contatto> searchContatto(String numero){
        List<Contatto> filteredContacts =  contatti
                .values()
                .stream()
                .filter(contatto-> contatto.getNumero().equalsIgnoreCase(numero)).toList();
        if(filteredContacts.isEmpty()) throw new RuntimeException("Non ci sono contatti con questo numero.");
        return filteredContacts;

    }

    public  List<Contatto> searchContatto(String nome,String cognome){
        return contatti
                .values()
                .stream()
                .filter(contatto->
                        contatto.getNome().equalsIgnoreCase(nome)
                                && contatto.getCognome().equalsIgnoreCase(cognome)).toList();

    }

    public  List<Contatto> searchContattiPreferiti(){
        return contatti
                .values()
                .stream()
                .filter(Contatto::isPreferito).toList();

    }















    public void inserisciContatto(Contatto contatto){
        if(contatti.containsKey(contatto.getIdContatto())) throw new RuntimeException("Contatto già esistente.");

        //Se hanno nome e cognome uguale
        if(!contatti.values().stream().filter(contatto1->
            contatto1.getCognome().equalsIgnoreCase(contatto.getCognome())&&contatto1.getNome().equalsIgnoreCase(contatto.getNome()))
                .toList().isEmpty()) throw new RuntimeException("Contatto già esistente.");



        contatti.put(contatto.getIdContatto(),contatto);
    }



    //Setters and getters
    public void setIdRubrica(int idRubrica) {
        this.idRubrica = idRubrica;
    }

    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti.stream().collect(Collectors.toMap(Contatto::getIdContatto, Function.identity()));
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
