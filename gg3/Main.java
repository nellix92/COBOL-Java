package esercizi.gg3;

import java.util.Scanner;

public class Main {

    private static final int MAX = 10;

    public static void main(String[] args) {
        System.out.println("----- Simulazione gioco dei dadi ---------");
        
        System.out.println("creiamo 2 giocatori");
        Giocatore g1 = new Giocatore("mauro", 1000);
        Giocatore g2 = new Giocatore("chris", 2000);
        
        System.out.println("creiamo il casino");
        Casino casino = new Casino("MonteCarlo", 10000);
        
        System.out.println("giochiamo " + MAX + " mani");

        int i = 0;
        boolean rigioca1 = true;
        boolean rigioca2 = true;
        while (i < MAX) {
            
            // se ha ancora soldi, gioca ancora
            if (rigioca1 && !eseguiPuntata(g1))
                rigioca1 = false;
            // se ha ancora soldi, gioca ancora
            if (rigioca2 && !eseguiPuntata(g2))
                rigioca2 = false;
                        
            int[] a = {g1.getPuntata(), g2.getPuntata()};
            if (giocatoriAttivi(a)) {
                if (casino.valutaPuntate(a)) {
                    // incassa preventivamente le puntate
                
                    int estratto = estrazione();
                    System.out.print("lancio ->");
                    System.out.println("... " + estratto + " ...");
        
                    if (estratto == g1.getNumeroGiocato()) {
                        g1.incassa();
                        casino.paga(g1.getPuntata());
                    }
                    System.out.println("Capitale del casinò dopo la puntata di " + g1.getNome() + ": " + casino.getCapitale());
        
                    if (estratto == g2.getNumeroGiocato()) {
                        g2.incassa();
                        casino.paga(g2.getPuntata());
                    }
                    
                    System.out.println("Capitale del casinò dopo la puntata di " + g2.getNome() + ": " + casino.getCapitale());
        
                    g1.reset();
                    g2.reset();
                    i++;
                }    
                else { // restituisce i soldi
                    System.out.println("il Casino NON ha abbastanza soldi...");
                    g1.recuperaPuntata();
                    g2.recuperaPuntata();
                }
        
            
                System.out.println(".......... SITUAZIONE ...........");
                System.out.println("giocatore 1: " + g1.getBudget());
                System.out.println("giocatore 2: " + g2.getBudget());
                System.out.println("casino: " + casino.getCapitale());
                System.out.println(".......... .......... ...........");
            } else { 
                i = MAX;
                System.out.println("*** non ci sono giocatori attivi ***");
            }
        }
    }

    private static int estrazione() {
        Dado dado = new Dado();
        return dado.estrai();
    }
    
    private static boolean eseguiPuntata(Giocatore g) {
        Scanner sca = new Scanner(System.in);
        System.out.println(g.getNome() + " quanto vuoi puntare?");
        int puntata = sca.nextInt();
        if (g.getBudget() != 0) {
            while (puntata <= 0 || puntata > g.getBudget()) {
                System.out.println("errore, non puoi puntare questa cifra. Riprova");
                puntata = sca.nextInt();
            }
            
            System.out.println(g.getNome() + " su quale numero vuoi puntare?");
            int numero = sca.nextInt();
            while (numero < 1 || numero > 6) {
                System.out.println("errore, valore non compreso tra 1 e 6. Riprova");
                numero = sca.nextInt();
            }
            g.punta(puntata, numero);
            return true;
        } else {
            System.out.println(g.getNome() + " hai finito i soldi!! :(");
            return false;
        }
    }

    private static boolean giocatoriAttivi(int[] puntate) {
        int somma = 0;
        for (int puntata : puntate) {
            somma += puntata;
        }
        return somma != 0;
    }
}
