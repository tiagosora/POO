package Aula8;

public abstract class Veiculo implements KmPercorridosInterface{
    private String matricula, marca, modelo;
    private int cilindrada;

    public Veiculo(String matricula, String marca, String modelo, int cilindrada){
        this.matricula = matricula.toUpperCase();
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }
    public Veiculo(){}

    public String getMatricula() {
        return matricula;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public int getCilindrada() {
        return cilindrada;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        String matriculaString = matricula + "; ";
        String marcaString = marca + "; ";
        String modeloString = modelo + "; ";
        if(matricula.equals(null)){matriculaString = "";}
        if(marca.equals(null)){marcaString = "";}
        if(modelo.equals(null)){modeloString = "";}
        return matriculaString + marcaString + modeloString;
    }
}
