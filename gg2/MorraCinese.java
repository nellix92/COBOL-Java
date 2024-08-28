package esercizi.gg2;

import java.util.Random;
import java.util.Scanner;

public class MorraCinese {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] mosse = {"Sasso", "Carta", "Forbici"};

            int mossaComputer = random.nextInt(3);

            System.out.print("Inserisci la tua mossa (0 = Sasso, 1 = Carta, 2 = Forbici): ");
            int mossaGiocatore = scanner.nextInt();

            while(mossaGiocatore < 0 || mossaGiocatore > 2) {
                System.out.println("Immetti un valore valido 0 = Sasso, 1 = Carta, 2 = Forbici): ");
                mossaGiocatore = scanner.nextInt();
                }

            System.out.println("Mossa del computer: " + mosse[mossaComputer]);
            System.out.println("Tua mossa: " + mosse[mossaGiocatore]);

            if (mossaComputer == mossaGiocatore) {
                System.out.println("Pareggio!");
            } else if ((mossaGiocatore == 0 && mossaComputer == 2) ||
                       (mossaGiocatore == 1 && mossaComputer == 0) ||
                       (mossaGiocatore == 2 && mossaComputer == 1)) {
                System.out.println("Hai vinto!");
            } else {
                System.out.println("Hai perso!");
            }

        }
    }


