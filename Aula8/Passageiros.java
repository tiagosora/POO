package Aula8;

public class Passageiros extends Veiculo{
    private int quadro, peso, numPass;

    public Passageiros(String matricula, String marca, String modelo, int cilindrada, int quadro, int peso, int numPass){
        super(matricula, marca, modelo, cilindrada);
        this.quadro = quadro;
        this.peso = peso;
        this.numPass = numPass;
    }
    public int getQuadro() {
        return quadro;
    }
    public int getPeso() {
        return peso;
    }
    public int getNumPass() {
        return numPass;
    }
    public void setQuadro(int quadro) {
        this.quadro = quadro;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    @Override
    public String toString() {
        String quadroString = Integer.toString(quadro) + "; ";
        String pesoMalaString = Integer.toString(peso) + "; ";
        String numPassString = Integer.toString(numPass) + "; ";
        if (quadro == 0){quadroString = "";}
        if (peso == 0){pesoMalaString = "";}
        if (numPass == 0){numPassString = "";}
        return super.toString() + quadroString + pesoMalaString + numPassString;
    }
    
}
