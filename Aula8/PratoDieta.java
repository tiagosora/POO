package Aula8;

public class PratoDieta extends Prato{
	double limiteMaxCalorias;
	private double calorias=0;
	public PratoDieta(String nome, double limiteMaxCalorias) {
		super(nome);
		this.limiteMaxCalorias=limiteMaxCalorias;
	}
	public double getLimiteMaxCalorias() {
		return limiteMaxCalorias;
	}
	public void setLimiteMaxCalorias(double limiteMaxCalorias) {
		this.limiteMaxCalorias = limiteMaxCalorias;
	}
	public boolean addIngrediente(Alimento a){
		if((a.getCalorias()+calorias)>limiteMaxCalorias)
			return false;
		return super.addIngrediente(a);
	}
    
	@Override
	public String toString() {
		return "Dieta (" + limiteMaxCalorias + " Calorias) "+super.toString();
	}
}