package Aula8;

public class Alimento {
    private double proteinas;
    private double calorias;
    private double peso;
    
    
    public Alimento(double proteinas, double calorias, double peso) {
        this.setProteinas(proteinas);
        this.setCalorias(calorias);
        this.setPeso(peso);
    }


    public double getProteinas() {
         return proteinas*peso/100;
    }


    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }


    public double getCalorias() {
        return calorias*peso/100;
    }


    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }


    public double getPeso() {
        return peso;
    }


    public void setPeso(double peso) {
        this.peso = peso;
    }



    @Override
    public String toString(){
        return "Proteínas= " +proteinas + "; Calorias= " + calorias + "; Peso= " + peso;
    }
    

    @Override
	public int hashCode() { 
		return (int)(proteinas+calorias+peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alimento))
			return false;
		Alimento other = (Alimento) obj;
		if (calorias != other.getCalorias())
			return false;
		if (proteinas != other.getProteinas())
			return false;
		if (peso != other.getPeso())
			return false;
		return true;
	}
}
