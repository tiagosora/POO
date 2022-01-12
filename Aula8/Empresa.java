package Aula8;
import java.util.ArrayList;

public class Empresa {
    private String nome, codPostal, email;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Empresa(String nome, String codPostal, String email){
        this.nome = nome;
        this.codPostal = codPostal;
        this.email = email;
    }
    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getCodPostal() {
        return codPostal;
    }
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString(){
        String nomeString = nome + "; ";
        String codPostalString = codPostal + "; ";
        String emailString = email + "; ";
        if (nome.equals(null)){nomeString = "";}
        if (codPostal.equals(null)){codPostalString = "";}
        if (email.equals(null)){emailString = "";}
        return nomeString + codPostalString + emailString;
    }

    public Veiculo getVeiculo(String matricula){
        for (Veiculo i : veiculos){
            if(i.getMatricula().equals(matricula.toUpperCase())){
                return i;
            }
        }
        System.out.println("OPERAÇÃO NÃO EFETUADA! Viatura não associada a esta empresa!");
		return null;
    }
    
}
