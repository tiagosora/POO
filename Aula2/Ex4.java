package Aula2;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Montante investido? ");
        double qt = sc.nextDouble();
        System.out.print("Juro mensal? (%) ");
        double juros = sc.nextDouble();
        System.out.print("Meses? ");
        double m = sc.nextDouble();

        for(int i = 0; i<m; i++){
            qt = qt + qt*juros/100;
        }

        System.out.println("Valor total ao final de " + m + " meses: " + qt);

        sc.close();

    }
}
