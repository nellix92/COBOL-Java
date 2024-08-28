package esercizi.gg3;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	
	private List <Contatto> contatti;
	private int dimensione;	
	

	public Rubrica(int dimensione) {
		this.dimensione = dimensione;
		this.contatti = new ArrayList<>(dimensione);
	}
	
	
	public void CreaContatto (String nome, String cognome, int numero) {
		if (contatti.size() < dimensione) {
			contatti.add(new Contatto(nome, cognome, numero));
		}else {
			System.out.println("Posti in rubrica pieni");
		}
	}
	
	public void mostraContatto(int posizione) {
        if (posizione >= 0 && posizione < contatti.size()) {
            System.out.println(contatti.get(posizione));
        } else {
            System.out.println("Posizione non valida.");
        }
    }

    public void stampaTuttiContatti() {
        for (Contatto contatto : contatti) {
            System.out.println(contatto);
        }
    }

    public int numeroDiContattiRegistrati() {
        return contatti.size();
    }

    public int numeroDiPostiLiberi() {
        return dimensione - contatti.size();
    }

    public Contatto cercaContattoPerNome(String nome) {
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equalsIgnoreCase(nome)) {
                return contatto;
            }
        }
        return null;
    }

    public Contatto cercaContattoPerNumero(int numeroTelefonico) {
        for (Contatto contatto : contatti) {
            if (contatto.getNumero()==numeroTelefonico) {
                return contatto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica(5);

        rubrica.CreaContatto("Mario", "Rossi", 1234567890);
        rubrica.CreaContatto("Luigi", "Verdi", 1987654321);

        rubrica.stampaTuttiContatti();

        System.out.println("Contatti registrati: " + rubrica.numeroDiContattiRegistrati());
        System.out.println("Posti liberi: " + rubrica.numeroDiPostiLiberi());

        rubrica.mostraContatto(1);

        Contatto trovato = rubrica.cercaContattoPerNome("Luigi");
        if (trovato != null) {
            System.out.println("Contatto trovato: " + trovato);
        } else {
            System.out.println("Contatto non trovato.");
        }

        trovato = rubrica.cercaContattoPerNumero(1234567890);
        if (trovato != null) {
            System.out.println("Contatto trovato: " + trovato);
        } else {
            System.out.println("Contatto non trovato.");
        }
    }

}
