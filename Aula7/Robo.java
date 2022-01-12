package Aula7;

public class Robo extends ObjetoMovel{
    private String id;
    private String tipoString;
    private int golosMarcados;
    private enum Type{
        GuardaRedes, Avancado, Defesa, Medio
    }
    private boolean posseBola;
    
    public Robo(int x, int y, String id, String tipoString){
        super(x, y);
        this.id = id;
        try {
            this.tipoString = Type.valueOf(tipoString).toString();
        } catch (java.lang.IllegalArgumentException illegalArgumentException) {
            this.tipoString = null;
        }
        this.golosMarcados = 0;
        posseBola = false;
    }
    public String getId() {
        return id;
    }
    public String getTipoString() {
        return tipoString;
    }
    public int getGolosMarcados() {
        return golosMarcados;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setTipoString(String tipoString) {
        this.tipoString = tipoString;
    }
    public void setGolosMarcados(int golosMarcados) {
        this.golosMarcados = golosMarcados;
    }
    public boolean getPosseBola(){
        return posseBola;
    }
    public void setPosseBola(boolean posseBola) {
        this.posseBola = posseBola;
    }

    public void addGolosMarcados(){
        this.golosMarcados++;
    }
}
