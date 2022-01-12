package Aula9;

public class Data implements Comparable<Data> {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){return dia;}
    public int getMes(){return mes;}
    public int getAno(){return ano;}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ano);
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
		Data other = (Data) obj;
		if (Double.doubleToLongBits(dia) != Double.doubleToLongBits(other.dia))
			return false;
		if (Double.doubleToLongBits(mes) != Double.doubleToLongBits(other.mes))
			return false;
        if (Double.doubleToLongBits(ano) != Double.doubleToLongBits(other.ano))
			return false;    
		return true;
	}

    @Override public String toString(){
        return dia + "/" + mes + "/" + ano;
    }

    @Override
    public int compareTo(Data o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
