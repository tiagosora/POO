package Aula3;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double notaT = -1, notaP = -1, notaF, notaFa;
        String res;
        
        
        while (0 <= notaT || notaT <= 20){
            System.out.print("Nota Teórica? [0-200] ");
            notaT = sc.nextDouble();
        }
        
        while (0 <= notaP || notaP <= 20){
            System.out.print("Nota Prática? [0-200] ");
            notaP = sc.nextDouble();
        }
        
        notaF = 0.4 * notaT + 0.6 * notaP;
        notaFa = Math.floor(notaF);

        if (notaF > 66){
            res = "Aprovado";
        } else {
            res = "Reprovado";
        }
        
        System.out.println("O aluno foi " + res + " com média de " + notaFa + ".");
        sc.close();
        
    }
}
