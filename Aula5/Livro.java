package Aula5;

public class Livro {
    private int id; //(numérico e sequencial, começando em 100
    private String titulo; //String
    private String tipoEmprestimo; //CONDICIONAL ou NORMAL
    private int disponibilidade; 
    private static int count = 0;

    public Livro(int id, String titulo, String tipoEmprestimo) {
        this.id = id;
        count++;
        this.titulo = titulo; 
        this.tipoEmprestimo = tipoEmprestimo;
        this.disponibilidade = 1;
    }

    public Livro(String titulo, String tipoEmprestimo) {
        this.id = 100 + count;
        count++;
        this.titulo = titulo; 
        this.tipoEmprestimo = tipoEmprestimo;
        this.disponibilidade = 1;
    }

    public Livro(String titulo) {
        this.id = 100 + count;
        count++;
        this.titulo = titulo; 
        this.tipoEmprestimo = "NORMAL";
        this.disponibilidade = 1;
    }    

    public int getId(){ return id;}
    public String getTitulo(){ return titulo;}
    public String getTipoEmprestimo(){ return tipoEmprestimo;}
    public int getDisponibilidade(){ return disponibilidade;}
    
    public void setId(int id){ this.id = id; }
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public void setTipoEmprestimo(String tipoEmprestimo){ this.tipoEmprestimo = tipoEmprestimo; }
    public void setDisponibilidade(int disponibilidade){ this.disponibilidade = disponibilidade; }

    @Override
    public String toString() {
        return "Livro " + id + "; " + titulo + "; " + tipoEmprestimo + "; " + disponibilidade;
    }
}