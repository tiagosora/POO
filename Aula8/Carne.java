package Aula8;

public class Carne extends Alimento {

    private Variedade v; 

    public enum Variedade {
        vaca, porco, peru, frango, outra;
    }

    public Carne(double proteinas, double calorias, double peso, Variedade v) {
        super(proteinas, calorias, peso);
        this.setV(v);
        
    }

    public Variedade getV() {
        return v;
    }

    public void setV(Variedade v) {
        this.v = v;
    }

    @Override
    public String toString(){
        return super.toString() + "; Variedade= " + v;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result+=super.hashCode();
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Carne))
			return false;
		Carne other = (Carne) obj;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}

    
}

