package Aula5;
import java.util.ArrayList;
import java.util.Scanner;
public class Ex3 {
    public static final Scanner sc = new Scanner(System.in);
    public static Utilizador utilizadores[] = new Utilizador[100];
    public static Livro catalogo[] = new Livro[100];
    public static int MaxLivros = 3;
    public static void main(String[] args) {
        //Menu
        int n;
        
        System.out.println("\n\nMenu");
        System.out.println(
        "1 - inscrever utilizador\n" +
        "2 - remover utilizador\n" +
        "3 - imprimir lista de utilizadores\n" +
        "4 - registar um novo livro\n" +
        "5 - imprimir lista de livros\n" +
        "6 - emprestar\n" +
        "7 - devolver\n" +
        "8 - alterar o número máximo de empréstimos\n" +
        "9 - imprimir lista de infrações" +
        "10 - sair");
        System.out.print("Selecione uma das opções (1-8) ");
        n = sc.nextInt();
        sc.nextLine();
        action(n);      
    }
    public static void action(int n){
        switch (n) {
            case 1: 
                addUtilizador();
                main(null);
            case 2: 
                removeUtilizador();
                main(null);
            case 3: 
                printUtilizadores();
                main(null);
            case 4: 
                addLivro();
                main(null);
            case 5: 
                printLivros();
                main(null);
            case 6: 
                loanABook();
                main(null);
            case 7: 
                refundABook();
                main(null);
            case 8: 
                changeMax();
                main(null);
            case 9:
                printInfractions();
                main(null);
            case 10:
                System.out.println("\nO programa foi encerrado com sucesso!");
                sc.close(); 
                System.exit(0);
        }
    }
    public static void addUtilizador(){
        //Organizar a lista
        for (int i = 0; i < utilizadores.length-1; i++) {
            if (utilizadores[i] == null){
                utilizadores[i] = utilizadores[i + 1];
                utilizadores[i + 1] = null;
            }
        }
        //Organizar o lugar do próximo utilizador
        int count = utilizadores.length;
        for (int i = utilizadores.length - 1; i >= 0; i--){
            if (utilizadores[i] == null) {
                count = i;
            }
        }
        //Saber se a lista está cheia
        if (count == utilizadores.length){
            System.out.print("\nA lista está cheia. Tente remover um utilizador!");
        } else {
            //Se não estiver cheia, adicionar um utilizador
            System.out.print("\nNome? ");
            String nome = sc.nextLine();
            System.out.print("nMec? ");
            int nMec = sc.nextInt();
            sc.nextLine();
            System.out.print("Curso? ");
            String curso = sc.nextLine();
            utilizadores[count] = new Utilizador(nome, nMec, curso);
            System.out.println("\nAdicionou um novo utilizador com sucesso!");
        }
    }
    public static void removeUtilizador(){
        //Dados do utilizador a remover
        System.out.print("\nNome? ");
        String nome = sc.nextLine();
        System.out.print("nMec? ");
        int nMec = sc.nextInt();
        sc.nextLine();
        System.out.print("Curso? ");
        String curso = sc.nextLine();
        //Procurar o utilizador e remove-lo
        //Hit: da próxima vez tentar if (Ponto(nome, nMec, Curso).equals(utilizadores[i]))
        int p = -1;
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i] == null) {}
            else if (utilizadores[i].getNome().equals(nome) && utilizadores[i].getnMec() == nMec && utilizadores[i].getCurso().equals(curso)) {
                p = i;
            } 
        }
        if (p != -1) {
            utilizadores[p] = null;
            System.out.print("\nUtilizador removido com sucesso!");
        } else {
            System.out.print("\nUtilizador não encontrado!");
        }
    }
    public static void printUtilizadores() {
        System.out.println("\n-Início-");
        for (Utilizador utilizador : utilizadores) {
            if (utilizador != null) 
            System.out.println(utilizador);
        }
        System.out.println("-Fim-");
    }
    public static void addLivro() {
        //Organizar a lista
        for (int i = 0; i < catalogo.length-1; i++) {
            if (catalogo[i] == null){
                catalogo[i] = catalogo[i + 1];
                catalogo[i + 1] = null;
            }
        }
        //Organizar o lugar do próximo livro
        int count = catalogo.length;
        for (int i = catalogo.length - 1; i >= 0; i--){
            if (catalogo[i] == null) {
                count = i;
            }
        }  
        //Saber se a lista está cheia
        if (count == catalogo.length){
            System.out.print("\nA lista está cheia. Tente remover um livro!");
        } else {
            //Se não estiver cheia, adicionar um utilizador
            System.out.print("\nId? ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Título? ");
            String titulo = sc.nextLine();
            System.out.print("Tipo de Empréstimo? ");
            String tipoEmprestimo = sc.nextLine();
            catalogo[count] = new Livro(id, titulo, tipoEmprestimo);
            System.out.println("\nAdicionou um novo livro com sucesso!");
        }
    }
    public static void printLivros(){
        System.out.println("\n-Início-");
        for (Livro livro : catalogo) {
            if (livro != null)
            System.out.println(livro);
        }
        System.out.println("-Fim-");
    }
    public static void loanABook(){
        //Dados do utilizador e do livro
        System.out.print("\nId? ");
        int id = sc.nextInt();
        System.out.print("nMec? ");
        int nMec = sc.nextInt();
        //Posição do livro e do utilizador
        int pl = -1, pu = -1;
        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i] == null) {}
            else if (catalogo[i].getId() == id) {
                pl = i;
            }
        }
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i] == null) {}
            else if (utilizadores[i].getnMec() == nMec) {
                pu = i;
            }
        }
        //Condições que possam impossibilitar o empréstimo.
        if (pl == -1){
            System.out.println("\nO livro não se encontra registado! Verifique o valor do Id.");
        }
        else if (pu == -1){
            System.out.println("\nO utilizador não se encontra registado! Verifique o valor do nMec.");
        }
        else if (catalogo[pl].getTipoEmprestimo().equals("CONDICIONAL")){
            System.out.println("\nO livro não pode ser emprestádo. Tipo de Empréstimo = CONDICIONAL!");
        } else if (catalogo[pl].getDisponibilidade() == 0) {
            System.out.println("\nO livro já foi emprestado.");
        } else {
            //Emprestar o livro
            utilizadores[pu].setEmprestimo(catalogo[pl], MaxLivros);
            catalogo[pl].setDisponibilidade(0);
            System.out.println("\nO livro foi emprestado com sucesso!");
        }
    }
    public static void refundABook(){
        //Dados do utilizador e do livro
        System.out.print("\nId? ");
        int id = sc.nextInt();
        System.out.print("nMec? ");
        int nMec = sc.nextInt();
        //Posição do utilizador
        int pl = -1, pu = -1, plu = -1;
        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i] == null) {}
            else if (catalogo[i].getId() == id) {
                pl = i;
            }
        }
        for (int i = 0; i < utilizadores.length; i++) {
            if (utilizadores[i] == null) {}
            else if (utilizadores[i].getnMec() == nMec) {
                pu = i;
            }
        }
        if (pl == -1){
            System.out.println("\nO livro não se encontra registado! Verifique o valor do Id.");
        }
        else if (pu == -1){
            System.out.println("\nO utilizador não se encontra registado! Verifique o valor do nMec.");
        } else {
            //Posição do livro no inventário do utilizador
            ArrayList<Livro> userLivros = utilizadores[pu].getLivrosRequisitados();
            for (int i = 0; i < userLivros.size(); i++) {
                if (userLivros.get(i) == null) {}
                else if (userLivros.get(i).getId() ==  id) {
                    plu = i;
                }
            }
            //Condições que possam impossibilitar o empréstimo.
            if (plu == -1){
                System.out.println("\nO livro não se encontra com utilizador!");
            } else {
                //Devolver o livro
                utilizadores[pu].setRefund(plu);
                catalogo[pl].setDisponibilidade(1);
                System.out.println("\nO livro foi devolvido com sucesso!");
            }
        }
    }
    public static void changeMax(){
        System.out.print("\nNovo número máximo de Empréstimos? ");
        MaxLivros = sc.nextInt();
        sc.nextLine();
    }
    public static void printInfractions(){
        System.out.println("\n-Início-");
        for (int i = 0; i < utilizadores.length; i++){
            if (utilizadores[i] == null){}
            else if (utilizadores[i].getLivrosRequisitados().size() > MaxLivros){
                System.out.println(utilizadores[i]);
            }
        }
        System.out.println("-Fim-");
    }
}
