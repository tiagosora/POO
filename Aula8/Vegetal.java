package Aula8;

public class Vegetal extends Alimento implements Vegetariano{
	String nome;
	
	public Vegetal( double proteinas, double calorias, double peso, String nome) {
		super(proteinas, calorias, peso);
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return super.toString() + "; Nome= " + nome;
	}
}

