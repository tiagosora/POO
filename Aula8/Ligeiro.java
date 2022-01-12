package Aula8;

public class Ligeiro extends Veiculo{
    private int quadro, capacidadeMala;

    public Ligeiro(String matricula, String marca, String modelo, int cilindrada, int quadro, int capacidadeMala){
        super(matricula, marca, modelo, cilindrada);
        this.quadro = quadro;
        this.capacidadeMala = capacidadeMala;
    }

    public int getQuadro() {
        return quadro;
    }
    public int getCapacidadeMala() {
        return capacidadeMala;
    }

    public void setQuadro(int quadro) {
        this.quadro = quadro;
    }
    public void setCapacidadeMala(int capacidadeMala) {
        this.capacidadeMala = capacidadeMala;
    }

    public void trajeto(int quilometros) {
    }
    public int ultimoTrajeto() {
        return 0;
    }
    public int distanciaTotal() {
        return 0;
    }

    @Override
    public String toString(){
        String quadroString = Integer.toString(quadro) + "; ";
        String capacidadeMalaString = Integer.toString(capacidadeMala) + "; ";
        if (quadro == 0){quadroString = "";}
        if (capacidadeMala == 0){capacidadeMalaString = "";}
        return super.toString() + quadroString + capacidadeMalaString;
    }
}
