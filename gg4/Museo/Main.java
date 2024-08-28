package esercizi.gg4.Museo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        Museo museo = new Museo("Museo d'Arte", 2);

        while (true) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Carica opera");
            System.out.println("2. Sposta opera dalla sala al deposito");
            System.out.println("3. Cerca opera");
            System.out.println("4. Stampa sala");
            System.out.println("5. Stampa deposito");
            System.out.println("6. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); 

            switch (scelta) {
                case 1:
                    System.out.println("Scegli il tipo di opera:");
                    System.out.println("1. Quadro");
                    System.out.println("2. Statua");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Inserisci l'autore: ");
                    String autore = scanner.nextLine();

                    System.out.print("Inserisci il titolo: ");
                    String titolo = scanner.nextLine();

                    if (tipo == 1) {
                        System.out.print("Inserisci la tecnica: ");
                        String tecnica = scanner.nextLine();
                        Quadro quadro = new Quadro(autore, titolo, tecnica);
                        museo.carica(quadro);
                    } else if (tipo == 2) {
                        System.out.print("Inserisci il materiale: ");
                        String materiale = scanner.nextLine();

                        System.out.print("Inserisci l'altezza: ");
                        double altezza = scanner.nextDouble();
                        Statua statua = new Statua(autore, titolo, materiale, altezza);
                        museo.carica(statua);
                    }
                    break;

                case 2:
                    System.out.print("Inserisci la posizione dell'opera da spostare: ");
                    int posizione = scanner.nextInt();
                    Opera operaSpostata = museo.sposta(posizione);
                    if (operaSpostata != null) {
                        System.out.println("Opera spostata in deposito: " + operaSpostata);
                    } else {
                        System.out.println("Posizione non valida.");
                    }
                    break;

                case 3:
                    System.out.print("Inserisci il titolo dell'opera da cercare: ");
                    String titoloDaCercare = scanner.nextLine();
                    Opera operaTrovata = museo.cerca(titoloDaCercare);
                    if (operaTrovata != null) {
                        System.out.println("Opera trovata: " + operaTrovata);
                    } else {
                        System.out.println("Opera non trovata.");
                    }
                    break;

                case 4:
                    System.out.println("Opere in sala:");
                    museo.stampaSala();
                    break;

                case 5:
                    System.out.println("Opere in deposito:");
                    museo.stampaDeposito();
                    break;

                case 6:
                    System.out.println("Uscita dal programma...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opzione non valida.");
            }
        }
	}

}
