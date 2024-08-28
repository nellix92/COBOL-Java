package esercizi.gg5.ArcoNoe;

import java.util.ArrayList;

public class Arca {
	ArrayList<Animale> animali = new ArrayList<Animale>();
	
	
	public void salva (Animale a) {
		animali.add(a);
	}
	
	public int getNumeroAnimali () {
		return animali.size();
	}
	

    public String coro() {
        StringBuilder coro = new StringBuilder();
        for (Animale a : animali) {
            coro.append(a.verso()).append(" ");
        }
        return coro.toString().trim();
    }
	
    @Override
    public String toString() {
        StringBuilder descrizione = new StringBuilder();
        for (Animale a : animali) {
            descrizione.append(a.toString()).append("\n");
        }
        return descrizione.toString().trim();
    }
	
}
