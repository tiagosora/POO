package Aula7;

public class Bola extends ObjetoMovel{
    private String cor;

    public Bola(int x, int y, String cor){
        super(x, y);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
