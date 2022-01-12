package Aula8;
import java.util.ArrayList;
import java.lang.Comparable;

public class Prato implements Comparable<Prato> {
    private String nome;
    ArrayList<Alimento> composicao = new ArrayList<Alimento>();
	double caloriasTotais=0;
    public Prato(String nome) {
        this.setNome(nome);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getCaloriasTotais() {
		return caloriasTotais;
	}
    public boolean addIngrediente(Alimento a){
		for(Alimento ing:composicao) {
			if(ing.equals(a)) {
				return false;
			}
		}
		composicao.add(a);
		this.caloriasTotais+=a.getCalorias();
		return true;
	}

    @Override
    public String toString(){
        return "Nome= " +nome + "; Composição= " + composicao;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((composicao == null) ? 0 : composicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		for(Alimento a:composicao) {
			result+=a.hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Prato))
			return false;
		Prato other = (Prato) obj;
		if (composicao == null) {
			if (other.composicao != null)
				return false;
		} else if (!composicao.equals(other.composicao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
    public int compareTo(Prato p) {
		if(this.caloriasTotais>p.getCaloriasTotais())
			return 1;
		else if(this.caloriasTotais<p.getCaloriasTotais())
			return -1;
		return 0;
	}
}
 