package esercizi.gg3;

import java.util.Random;

public class Dado {
    private static final int NUMERO_FACCIE = 6;
    private Random random;

    public Dado() {
        this.random = new Random();
    }

    public int estrai() {
        return random.nextInt(NUMERO_FACCIE) + 1; // Genera un numero tra 1 e 6
    }
}




