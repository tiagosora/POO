package Aula7;

import java.util.ArrayList;

public class Jogo {
    private ArrayList<Equipa> equipas;
    private Bola bola;
    private static int duracaoJogo = 60; //min
    private int tempoDecorrido;
    
    public Jogo(Bola bola){
        this.bola = bola;
        this.tempoDecorrido = 0;
    }
    public Jogo(ArrayList<Equipa> equipas, Bola bola) {
        this.equipas = equipas;
        this.bola = bola;
        this.tempoDecorrido = 0;
    }
    public void setEquipas(ArrayList<Equipa> equipas) {
        this.equipas = equipas;
    }
    public void setBola(Bola bola) {
        this.bola = bola;
    }
    public ArrayList<Equipa> getEquipas() {
        return equipas;
    }
    public Bola getBola() {
        return bola;
    }
    public int getTempoDecorrido() {
        return tempoDecorrido;
    }
    public int getDuracaoJogo() {
        return duracaoJogo;
    }

    public void addTempoDecorrido(int tempo){
        this.tempoDecorrido += tempo;
        terminarJogo(this.tempoDecorrido);
    }
    public void terminarJogo(int tempoDecorrido){
        if (Jogo.duracaoJogo < tempoDecorrido){
            System.out.println("\nO jogo terminou! RESULTADO FINAL: " + this.equipas.get(0).getGolosMarcados() + " / " + this.equipas.get(0).getGolosSofridos());
            System.out.println("");
            for (int i = 0; i < equipas.size(); i++){
                int equipaDP = 0;
                for (int e = 0; e < equipas.get(i).getRobos().size(); e++){
                    System.out.println("O jogador " + equipas.get(i).getRobos().get(e).getId() + " correu um total de " + equipas.get(i).getRobos().get(e).getDistanciaPercorrida() + " m.");
                    equipaDP += equipas.get(i).getRobos().get(e).getDistanciaPercorrida();
                }
                System.out.println("No total a equipa " + equipas.get(i).getNome() + " correu " + equipaDP + " metros!");
                System.out.println("");
            }
            System.exit(0);
        }
    }
}
