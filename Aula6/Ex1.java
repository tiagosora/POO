package Aula6;

public class Ex1 {
    public static void main(String[] args) {
        Data d = new Data(5, 10, 1988);
        Pessoa p = new Pessoa("Ana Santos", 98012244, d);
        System.out.println(p);

        Aluno al = new Aluno ("Andreia Melo", 9855678,
        new Data(18, 7, 1990), new Data (1, 9, 2018));
        Bolseiro bls = new Bolseiro ("Igor Santos", 8976543, new Data(11, 5, 1985));
        bls.setBolsa(1050);

        System.out.println("Aluno: " + al.getNome());
        System.out.println(al);

        System.out.println("Bolseiro : " + bls.getNome() + ", NMec : " + bls.getNMec() + ", Bolsa : " + bls.getBolsa());
        System.out.println(bls);

    }
}   
