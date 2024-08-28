package Esercizi.EsercizioContest;

import java.util.ArrayList;

public class Contest {

    ArrayList<Performer> garaDiArtisti;

    public  Contest(){
        garaDiArtisti = new ArrayList<>();
    }

    public void signUp(Performer p) throws PerformerDuplicatoException {
        if(garaDiArtisti.contains(p)) throw new PerformerDuplicatoException(p.getNome());
        garaDiArtisti.add(p);

    }

    public void registerVoteFor(Performer p ) throws PerformerInesistenteException {
        if(!garaDiArtisti.contains(p)) throw new PerformerInesistenteException();
        for(Performer p2: garaDiArtisti){
            if(p.equals(p2)){
                p.addVoto();
            }
        }

    }

    @Override
    public String toString() {
        return "Contest{" +
                "garaDiArtisti=" + garaDiArtisti +
                '}';
    }

    public Performer getWinner(){
        int max = 0;
        Performer p2 = null;
        for(Performer p: garaDiArtisti){
            if(p.voti>max){
                max = p.voti;
                p2 = p;
            }
        }
        return p2 ;

    }
}
