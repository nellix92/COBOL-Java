package Esercizi.EsercizioPrenotazioneCamere;

import java.util.ArrayList;

public class Room {

    int numero;
    ArrayList<Reservation> arrayList;
    public Room(int numero) throws RoomNotExistsException {
        if(numero < 100 || numero > 599) throw new RoomNotExistsException(numero);
        arrayList = new ArrayList<>();
        this.numero = numero;
    }

    public Reservation reserve(String nome,int dataDiInizio,int dataDiFine) throws RoomAlreadyReservedException {
        Reservation r =  new Reservation(nome,dataDiInizio,dataDiFine,numero);
        if(isAlreadyReserved(r)) throw new RoomAlreadyReservedException(numero);
        arrayList.add(r);
        return r;

    }

    private boolean isAlreadyReserved(Reservation r){
        for (Reservation reservation : arrayList) {
            if(reservation.equals(r)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Reservation> reservations(){
        return arrayList;
    }






}
