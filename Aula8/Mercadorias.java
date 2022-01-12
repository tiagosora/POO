package Aula8;

public class Mercadorias extends Veiculo{
    private int quadro, peso, cargaMax;

    public Mercadorias(String matricula, String marca, String modelo, int cilindrada, int quadro, int peso, int cargaMax){
        super(matricula, marca, modelo, cilindrada);
        this.quadro = quadro;
        this.peso = peso;
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString(){
        String quadroString = Integer.toString(quadro) + "; ";
        String pesoMalaString = Integer.toString(peso) + "; ";
        String cargaMaxString = Integer.toString(cargaMax) + "; ";
        if (quadro == 0){quadroString = "";}
        if (peso == 0){pesoMalaString = "";}
        if (cargaMax == 0){cargaMaxString = "";}
        return super.toString() + quadroString + pesoMalaString + cargaMaxString;
    }

    public int getQuadro() {
        return quadro;
    }
    public int getPeso() {
        return peso;
    }
    public int getCargaMax() {
        return cargaMax;
    }
    public void setQuadro(int quadro) {
        this.quadro = quadro;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
}
