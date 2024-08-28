package Esercizi.EsercizioPrenotazioneCamere;

public class RoomAlreadyReservedException extends RuntimeException{
    public RoomAlreadyReservedException(int number){
        super("La stanza " + number + " è già occupata.");
    }
}
