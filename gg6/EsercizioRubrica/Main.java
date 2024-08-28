package Esercizi.EsercizioRubrica;

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica(10);

        try{
            rubrica.inserisciContatto(new Contatto("Anoir", "Prova","434123421"));
            rubrica.inserisciContatto(new Contatto("Anoir", "Prova","434123421"));
            rubrica.inserisciContatto(new Contatto("Stefano", "Prova","434123421"));
            rubrica.inserisciContatto(new Contatto("Giacomo", "Prova","434123421"));
            for(int i = 0;i<11;i++){
                rubrica.inserisciContatto(new Contatto("Giacomo1", "Prova","434123421"));

            }
            rubrica.cercaPerNome("Anoir");
        }
        catch (ContactException e){
            System.out.println(e.getMessage());

        }
    }
}
