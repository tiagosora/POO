package Aula3;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int montante = -1, taxa = -1;

        while (montante%1000 != 0) {
            System.out.print("Montante? [!Múltiplo de 1000!] ");
            montante = sc.nextInt(); 
        }
        while (0 >= taxa || taxa > 5) {
            System.out.print("Taxa de juros? [!Entre 0% e 5%!] ");
            taxa = sc.nextInt(); 
        }
        
        for (int i=0; i<12; i++) {
            System.out.println(montante);
            montante = montante+montante*taxa/100;

        }
        
        sc.close();
    }
}
