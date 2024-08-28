package Esercizi.EsercizioRubrica;

public class ContactException extends Exception{
    public ContactException(){
        super("La lista è piena");
    }

    public ContactException(String message){
        super(message);
    }
}
