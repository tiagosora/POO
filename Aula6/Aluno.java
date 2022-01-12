package Aula6;
import java.time.LocalDateTime;  

public class Aluno extends Pessoa{
    private int nMec;
    private Data iDataInsc;
    public static int counter = 100;

    public Aluno(String iNome, int iBI, Data iDataNasc, Data iDataInsc){
        super(iNome, iBI, iDataNasc);
        nMec = counter;
        counter++;
        this.iDataInsc = iDataInsc;
    }
    public Aluno(String iNome, int iBI, Data iDataNasc){
        super(iNome, iBI, iDataNasc);
        nMec = counter;
        counter++;
        this.iDataInsc = new Data(LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getYear());
    }

    public int getNMec(){return nMec;}
    public Data getIDataInsc(){return iDataInsc;}

    @Override public String toString(){
        return super.getNome() + ", " + Integer.toString(super.getCc()) + ", " + super.getDataNasc() + ", " + nMec + ", " + iDataInsc;
    }
}
