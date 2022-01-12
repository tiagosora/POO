package Aula6;

public class Retangulo extends Figuras {
    private double l;
    private double a;

    public Retangulo (double l, double a, String cor) {
		super(cor); 
        this.l = l;
        this.a = a;
    }

    public double getL() { return l; }
    public double getA() { return a; }

    public double area(){
        return l*a;
    }

    public double perimetro(){
        return 2 * l + 2 * a;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(l);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retangulo other = (Retangulo) obj;
		if (Double.doubleToLongBits(l) != Double.doubleToLongBits(other.l))
			return false;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		return true;
	}

    @Override
    public String toString() { return "Retangulo: l = " + l + "; a = " + a + "; cor = " + super.getCor(); }
    
}
