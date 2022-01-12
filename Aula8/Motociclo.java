package Aula8;

public class Motociclo extends Veiculo{
    public enum Tipo {
        desportivo,estrada
    }
    private Tipo tipo;

    public Motociclo(String matricula, String marca, String modelo, int cilindrada, String tipo){
        super(matricula, marca, modelo, cilindrada);
        try {
            this.tipo = Motociclo.Tipo.valueOf(tipo);
        } catch (java.lang.IllegalArgumentException typIllegalArgumentException){
            this.tipo = null;
        }
    }
    public Motociclo(String matricula, String marca, String modelo, int cilindrada, Tipo tipo){
        super(matricula, marca, modelo, cilindrada);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = Tipo.valueOf(tipo);
    }
    
    @Override
    public String toString(){
        String tipoString;
        if(tipo == null){tipoString = "";} else {tipoString = tipo + "; ";} 
        return super.toString() + tipoString;
    }
}
