package esercizi.gg5.Traghetto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biglietteria biglietteria = new Biglietteria();
        Scanner scanner = new Scanner(System.in);
        int scelta;
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Aggiungi Persona");
            System.out.println("2. Aggiungi Auto");
            System.out.println("3. Aggiungi Moto");
            System.out.println("4. Aggiungi Tir");
            System.out.println("5. Ricevi Pagamento");
            System.out.println("6. Visualizza Cassa");
            System.out.println("7. Esci");
            System.out.print("Seleziona un'opzione: ");
            
            while (true) {
                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.print("Input non valido. Seleziona un'opzione valida: ");
                    scanner.next();
                }
            }

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    while(nome.isEmpty()) {
                    	System.out.println("Inserisci il tuo nome: campo richiesto");
                    	nome = scanner.nextLine();
                    }
                    System.out.print("Inserisci cognome: ");
                    String cognome = scanner.nextLine();
                    while(cognome.isEmpty()) {
                    	System.out.println("Inserisci il tuo cognome: campo richiesto");
                    }
                    Persona persona = new Persona(nome, cognome);
                    biglietteria.aggiungiInCoda(persona);
                    System.out.println("Persona aggiunta in coda.");
                    break;
                
                case 2:
                    System.out.print("Inserisci targa: ");
                    String targaAuto = scanner.nextLine();
                    System.out.print("Inserisci numero passeggeri: ");
                    int numPasseggeriAuto = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Inserisci tipo (MINI, STANDARD, SUV): ");
                    String tipoAuto = scanner.nextLine().toUpperCase();
                    Auto.Tipo tipo;
                    try {
                        tipo = Auto.Tipo.valueOf(tipoAuto);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo non valido.");
                        break;
                    }
                    Auto auto = new Auto(targaAuto, numPasseggeriAuto, tipo);
                    biglietteria.aggiungiInCoda(auto);
                    System.out.println("Auto aggiunta in coda.");
                    break;
                
                case 3:
                    System.out.print("Inserisci targa: ");
                    String targaMoto = scanner.nextLine();
                    System.out.print("Inserisci numero passeggeri: ");
                    int numPasseggeriMoto = scanner.nextInt();
                    scanner.nextLine(); 
                    if (numPasseggeriMoto > 2) {
                        System.out.println("Una moto può avere al massimo 2 passeggeri.");
                        break;
                    }
                    Moto moto = new Moto(targaMoto, numPasseggeriMoto);
                    biglietteria.aggiungiInCoda(moto);
                    System.out.println("Moto aggiunta in coda.");
                    break;
                
                case 4:
                    System.out.print("Inserisci targa: ");
                    String targaTir = scanner.nextLine();
                    System.out.print("Inserisci numero passeggeri: ");
                    int numPasseggeriTir = scanner.nextInt();
                    System.out.print("Inserisci tonnellate merce: ");
                    double tonnellateMerce = scanner.nextDouble();
                    scanner.nextLine(); 
                    Tir tir = new Tir(targaTir, numPasseggeriTir, tonnellateMerce);
                    biglietteria.aggiungiInCoda(tir);
                    System.out.println("Tir aggiunto in coda.");
                    break;
                
                case 5:
                    try {
                        Tariffa t = biglietteria.riceviPagamento();
                        System.out.println("Pagamento ricevuto: " + t.calcolaTariffa());
                    } catch (IllegalStateException e) {
                        System.out.println("La coda è vuota.");
                    }
                    break;
                
                case 6:
                    System.out.println("Cassa totale: " + biglietteria.getCassa());
                    break;
                
                case 7:
                    System.out.println("Uscita dal programma.");
                    scanner.close();
                    return;
            }
        }
    }
}
