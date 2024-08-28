package esercizi.gg3;

import java.util.Date;
import java.util.Scanner;

public class Tamagotchi {
	private String nome;
	private String specie;
	private double peso;
	private double altezza;
	private int energia;
	
	
	public Tamagotchi(String nome, String specie) {
		this.nome = nome;
		this.specie = ControllaSpecie(specie) ;
		this.setAltezza();
		this.setPeso();
		this.energia = 3;
	}
	
	public Tamagotchi(String nome) {
		this.nome = nome;
		this.specie = "1";
		this.setAltezza();
		this.setPeso();
		this.energia = 3;
	}
	
	public String getSpecie() {
		return specie;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltezza() {
		return altezza;
	}

	public int getEnergia() {
		return energia;
	}
	
	private void setPeso() {
		switch (this.specie) {
		case "cane":
			this.peso = 300;
			break;
		case "gatoo":
			this.peso = 100;
			break;
		case "canarino":
			this.peso = 10;
			break;
		case "coniglio":
			this.peso = 100;
			break;
		}
		
	}
	
	private void setAltezza() {
		switch (this.specie) {
		case "cane":
			this.altezza = 20;
			break;
		case "gatto":
			this.altezza = 10;
			break;
		case "canarino":
			this.altezza = 3;
			break;
		case "coniglio":
			this.altezza = 10;
			break;
		}
		
	}
	
	@Override
	public String toString() {
		return "Tamagotchi [nome=" + nome + ", specie=" + specie + ", peso=" + peso + ", altezza=" + altezza
				+ ", energia=" + energia + "]";
	}
	
	public String ControllaSpecie(String specie) {
		switch(specie) {
			case "1"  :
				return "cane";
			case "2":
				return "gatto";
			case "3"  :
				return "canarino";
			case "4"  :
				return "coniglio";
			default:
				return "cane";
		}
	}
	
	

	public boolean Mangia() {
		if(energia < 10) {
			this.peso += 150;
			this.altezza += 1;
			this.energia += 1;
			return true;
		}
		return false;
	}
	
	public boolean Dorme () {
		if(energia < 10) {
		energia += 1;
		return true;
		}
		return false;
	}
	
	public boolean Gioca () {
		if(energia == 0) {
			this.peso -= 100;
			this.energia += 1;
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Tamagotchi t1 = new Tamagotchi("balu", "1");
		Tamagotchi t2 = new Tamagotchi("nemo");
		t1.Dorme();
		t1.Dorme();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println("Digita il nome del tuo Tamagotchi:");
		String nome = s.nextLine();
		System.out.println("Di che specie è il tuo animale?");
		System.out.println("[1]Cane, [2]Gatto, [3]Canarino, [4]Coniglio");
		String specie = s.nextLine();
		Tamagotchi t3 = new Tamagotchi(nome,specie);
		System.out.println(t3);
		}
}