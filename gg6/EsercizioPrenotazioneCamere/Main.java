package Esercizi.EsercizioPrenotazioneCamere;

public class Main {
    public static void main(String[] args)  {
        Room r = new Room(103);
        Reservation p1 = r.reserve("mario rossi", 105, 120);
        Reservation p2 = r.reserve("anna bianchi", 5, 20);
        Reservation p3 = r.reserve("piero neri", 20, 22);
        Reservation p4 = r.reserve("gianna gialli", 200, 222);
        for (Reservation p: r.reservations())
            System.out.println(p.getNome());


        Reservation p5 = r.reserve("tony blu", 21, 23);
    }


}
