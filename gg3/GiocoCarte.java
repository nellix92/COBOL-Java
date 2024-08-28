package esercizi.gg3;

public class GiocoCarte {
    public static void main(String[] args) {
        MazzoCarte mazzo = new MazzoCarte();
        mazzo.mischia();

        Partecipante giocatore1 = new Partecipante("Giocatore 1");
        Partecipante giocatore2 = new Partecipante("Giocatore 2");

        int numeroMani = 10; // Imposta il numero di mani
        for (int i = 0; i < numeroMani; i++) {
            Carta carta1 = mazzo.estrae();
            Carta carta2 = mazzo.estrae();

            giocatore1.prende(carta1);
            giocatore2.prende(carta2);

            if (carta1.compareTo(carta2) > 0) {
                giocatore1.incrementaPunteggio();
            } else if (carta1.compareTo(carta2) < 0) {
                giocatore2.incrementaPunteggio();
            } // In caso di parità, nessuno prende il punto

            System.out.println(giocatore1);
            System.out.println(giocatore2);
        }

        System.out.println("Risultato finale:");
        System.out.println(giocatore1.getNome() + ": " + giocatore1.getPunteggio() + " punti");
        System.out.println(giocatore2.getNome() + ": " + giocatore2.getPunteggio() + " punti");

        if (giocatore1.getPunteggio() > giocatore2.getPunteggio()) {
            System.out.println(giocatore1.getNome() + " vince!");
        } else if (giocatore1.getPunteggio() < giocatore2.getPunteggio()) {
            System.out.println(giocatore2.getNome() + " vince!");
        } else {
            System.out.println("Pareggio!");
        }
    }
}

