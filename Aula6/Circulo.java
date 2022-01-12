package Aula6;

public class Circulo extends Figuras {
    private Ponto c;
    private double r;
    public Circulo(Ponto c, double r, String cor){
		super(cor);
        this.c = c;
        this.r = r;
    }

    public Ponto getCentro() { return c; }
    public double getRaio() { return r; }

    public double area (){
        return Math.pow(r, 2) * Math.PI;
    }

    public double perimetro(){
        return 2 * Math.PI * r;
    }

    public boolean intersetaCirculo(Circulo c2) {
        double d = Math.sqrt(Math.pow(c.getX()+c2.getCentro().getX(), 2) + Math.pow(c.getY()+c2.getCentro().getY(), 2));
        if (d > (r + c2.getRaio())){
            return true;
        }
        return false;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
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
		Circulo other = (Circulo) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}

    @Override
    public String toString() { return "Circulo: c = " + c + "; r = " + r + "; cor = " + super.getCor(); }
}
