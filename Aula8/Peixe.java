package Aula8;

public class Peixe extends Alimento {
    private Tipo t;
    public enum Tipo{
        congelado, fresco;
    }
    public Peixe(double proteinas, double calorias, double peso, Tipo t) {
        super(proteinas, calorias, peso);
        this.setT(t);
    }
    public Tipo getT() {
        return t;
    }
    public void setT(Tipo t) {
        this.t = t;
    }
    @Override
    public String toString(){
        return super.toString() +"; Tipo= " +t;
    }
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result+=super.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Peixe))
			return false;
		Peixe other = (Peixe) obj;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}
}
