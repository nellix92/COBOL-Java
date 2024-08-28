package Esercizi.EsercizioRubrica;

import java.util.Arrays;

public class Rubrica {

    Contatto [] contatti;
    int contattiSalvati=0;

    public Rubrica(int length){
        contatti = new Contatto[length];
    }
    public boolean inserisciContatto(Contatto contatto) throws ContactException {
        try{
            contatti[contattiSalvati] = contatto;
            contattiSalvati++;
        }catch(Exception e){
            throw new ContactException("La rubrica è piena");
        }
        return true;


    }


    public Contatto mostraContatto(int i) throws ContactException {
        try{
            return contatti[i];
        }catch(Exception e){
            throw new ContactException("La rubrica è piena");
        }


    }

    @Override
    public String toString() {
        return "Rubrica{" +
                "contatti=" + Arrays.toString(contatti) +
                ", contattiSalvati=" + contattiSalvati +
                '}';
    }

    public int contattiRegistrati(){
        return  contattiSalvati;

    }

    public int numeroPostiLiberi(){
        return contatti.length-contattiSalvati;
    }


    public Contatto cercaPerNome(String nome) throws ContactException{



        for(Contatto contatto: contatti){
            if(contatto!= null && contatto.nome.equalsIgnoreCase(nome))
                return contatto;
        }

        throw new ContactException("Contatto" + nome + " non trovato");

    }

    public Contatto contattoCercaPerNumero(String numero) throws ContactException {
        for(Contatto contatto: contatti){
            if(contatto!= null && contatto.numero.equalsIgnoreCase(numero))
                return contatto;
        }
        throw new ContactException("Contatto" + numero + " non trovato");
    }
}
