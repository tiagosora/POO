package Aula8;

public class Taxi extends Ligeiro{
    private int numLicenca;

    public Taxi(String matricula, String marca, String modelo, int cilindrada, int quadro, int capacidadeMala, int numLicenca){
        super(matricula, marca, modelo, cilindrada, quadro, capacidadeMala);
        this.numLicenca = numLicenca;
    }
    public int getNumLicenca() {
        return numLicenca;
    }
    public void setNumLicenca(int numLicenca) {
        this.numLicenca = numLicenca;
    }
    
    @Override
    public String toString() {
        String numLicencaString = Integer.toString(numLicenca) + "; ";
        if(numLicenca == 0){numLicencaString = "";}
        return super.toString() + numLicencaString; 
    }
}
