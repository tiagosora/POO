package Aula5;
import java.util.ArrayList;

public class Utilizador {
    private String nome;
    private int nMec;   
    private String curso;
    private ArrayList<Livro> livrosRequisitados = new ArrayList<>();

    public Utilizador(String nome, int nMec, String curso) {
        this.nome = nome;
        this.nMec =nMec;
        this.curso = curso;
        //this.livrosRequisitados = new Livro[3];
    }
    //Métodos get() 
    public String getNome(){ return nome;}
    public int getnMec(){ return nMec;}
    public String getCurso(){ return curso;}
    public ArrayList<Livro> getLivrosRequisitados(){ return livrosRequisitados;}
    //Métodos set()
    public void setNome(String nome){ this.nome = nome; }
    public void setnMec(int nMec){ this.nMec = nMec; }
    public void setCurso(String curso){ this.curso = curso; }
    public void setEmprestimo(Livro livro, int MaxLivros){
        //Organizar a lista 
        for (int i = 0; i < livrosRequisitados.size() - 1; i++) {
            if (livrosRequisitados.get(i) == null){
                livrosRequisitados.set(i, livrosRequisitados.get(i+1));
                livrosRequisitados.set(i+1, null);
            }
        }
        //Organizar o lugar do próximo livro
        int count = livrosRequisitados.size();
        for (int i = livrosRequisitados.size() - 1; i >= 0; i--){
            if (livrosRequisitados.get(i) == null) {
                count = i;
            }
        }  
        //Saber se a lista está cheia
        if (livrosRequisitados.size() >= MaxLivros){
            System.out.print("A lista está cheia. Tente devolver um livro!");
        } else {
            //Se não estiver cheia, emprestar um livro
            livrosRequisitados.add(count, livro);
            System.out.println("Adicionou um novo livro com sucesso!");
        }
    }
    public void setRefund(int plu){ livrosRequisitados.set(plu, null); }

    @Override
    public String toString() {
        return "Aluno: " + nMec + " ; " + nome + " ; " + curso;
    }
}
