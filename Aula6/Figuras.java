package Aula6;


public abstract class Figuras {
    private String cor;

    public Figuras(String cor){
        this.cor = cor.toLowerCase();
    }

    public String getCor(){return cor;}
    public void setCor(String cor){this.cor = cor;}

    @Override
    public String toString(){
        return cor;
    }
}
