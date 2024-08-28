package esercizi.gg4.Museo;

import java.util.ArrayList;


class Museo {
 private String nome;
 private ArrayList<Opera> sala;
 private int dimMaxSala;
 private ArrayList<Opera> deposito;

 public Museo(String nome, int dimMaxSala) {
     this.nome = nome;
     this.dimMaxSala = dimMaxSala;
     this.sala = new ArrayList<>();
     this.deposito = new ArrayList<>();
 }

 public String getNome() {
     return nome;
 }

 public void setNome(String nome) {
     this.nome = nome;
 }

 public int getDimMaxSala() {
     return dimMaxSala;
 }

 public void setDimMaxSala(int dimMaxSala) {
     this.dimMaxSala = dimMaxSala;
 }

 public void carica(Opera opera) {
     if (sala.size() < dimMaxSala) {
         sala.add(opera);
         opera.Esponi();
     } else {
         deposito.add(opera);
         opera.Riponi();
     }
 }

 public Opera sposta(int posizione) {
     if (posizione >= 0 && posizione < sala.size()) {
         Opera opera = sala.remove(posizione);
         opera.Riponi();
         deposito.add(opera);
         return opera;
     }
     return null;
 }

 public Opera cerca(String titolo) {
     for (Opera opera : sala) {
         if (opera.getTitolo().equals(titolo)) {
             return opera;
         }
     }
     for (Opera opera : deposito) {
         if (opera.getTitolo().equals(titolo)) {
             return opera;
         }
     }
     return null;
 }

 public void stampaSala() {
     for (Opera opera : sala) {
         System.out.println(opera);
     }
 }

 public void stampaDeposito() {
     for (Opera opera : deposito) {
         System.out.println(opera);
     }
 }
}
