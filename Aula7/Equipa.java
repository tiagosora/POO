package Aula7;
import java.util.ArrayList;

public class Equipa {
    private String nome;
    private String nomeResponsavel;
    private int golosMarcados;
    private int golosSofridos;
    private ArrayList<Robo> Robos;
    
    public Equipa(String nome, String nomeResponsavel) {
        this.nome = nome;
        this.nomeResponsavel = nomeResponsavel;
        this.golosMarcados = 0;
        this.golosSofridos = 0;
        this.Robos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }
    public int getGolosMarcados() {
        return golosMarcados;
    }
    public int getGolosSofridos() {
        return golosSofridos;
    }
    public ArrayList<Robo> getRobos() {
        return Robos;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    public void setGolosMarcados(int golosMarcados) {
        this.golosMarcados = golosMarcados;
    }
    public void setGolosSofridos(int golosSofridos) {
        this.golosSofridos = golosSofridos;
    }
    public void setRobos(ArrayList<Robo> robos) {
        Robos = robos;
    }
    public void addRobos(Robo robo){
        this.Robos.add(robo);
    }
    public void removeRobos(Robo robo){
        this.Robos.remove(robo);
    }
    
    public void marcarGolo(){
        this.golosMarcados++;
    }
    public void sofrerGolo(){
        this.golosSofridos++;
    }
}
