package esercizi.gg3;

import java.util.Random;

public class MazzoCarte {
    private Carta[] elenco;
    private int indiceProxCarta;

    public MazzoCarte() {
        elenco = new Carta[40];
        int indice = 0;
        for (int seme = 0; seme < 4; seme++) {
            for (int valore = 1; valore <= 10; valore++) {
                elenco[indice++] = new Carta(valore, seme);
            }
        }
        indiceProxCarta = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : elenco) {
            sb.append(carta).append("\n");
        }
        return sb.toString();
    }

    public void mischia() {
        Random rand = new Random();
        for (int i = elenco.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Carta temp = elenco[i];
            elenco[i] = elenco[j];
            elenco[j] = temp;
        }
    }

    public Carta estrae() {
        if (indiceProxCarta < elenco.length) {
            return elenco[indiceProxCarta++];
        } else {
            return null; // Mazzo esaurito
        }
    }
}
