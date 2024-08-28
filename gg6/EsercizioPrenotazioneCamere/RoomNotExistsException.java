package Esercizi.EsercizioPrenotazioneCamere;

public class RoomNotExistsException extends RuntimeException{


    public RoomNotExistsException(int number){
        super("La stanza " + number + " non esiste.");
    }
}
