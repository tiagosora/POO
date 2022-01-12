package Aula3;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double notaT, notaP, notaF;

        String lstA[][] = new String[1][3];
        lstA[0][0] = "NotaT";
        lstA[0][1] = "NotaP";
        lstA[0][2] = "Pauta";

        double lst[][] = new double[16][3];
        for (int i = 0; i < 16; i++) {
                int Aluno = i + 1;
            do {
                System.out.print("Nota Teórica do Aluno " + Aluno + "? [0-200] ");
                notaT = sc.nextDouble();  
            } while (0 > notaT || notaT > 200);
            do {
                System.out.print("Nota Prática do Aluno " + Aluno + "? [0-200] ");
                notaP = sc.nextDouble();
            } while(0 > notaP || notaP > 200);

            notaF = 0.4 * notaT + 0.6 * notaP;

            lst[i][0] = notaT;
            lst[i][1] = notaP;
            lst[i][2] = notaF;
        }
        
        System.out.println(String.format("%7s %7s %7s", lstA[0][0], lstA[0][1], lstA[0][2]));
        for (int i = 0; i < 16; i++) {
            System.out.println(String.format("%7.1f %7.1f %7.1f", lst[i][0], lst[i][1], lst[i][2]));
        }

        sc.close();
    }
    
}
