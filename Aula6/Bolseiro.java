package Aula6;

public class Bolseiro extends Aluno{
    private int bolsa;

    public Bolseiro(String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
        super(iNome, iBI, iDataNasc, iDataInsc);
        //Definir a bolsa
    }
    public Bolseiro(String iNome, int iBI, Data iDataNasc) {
        super(iNome, iBI, iDataNasc);
        //Definir a bolsa
    }

    public int getBolsa(){return bolsa;}
    public String getNome(){return super.getNome();}
    public void setBolsa(int montante) {
        bolsa = montante;
    }

    @Override public String toString(){
        return super.getNome() + ", " + Integer.toString(super.getCc()) + ", " + super.getDataNasc().toString();      
    }
}