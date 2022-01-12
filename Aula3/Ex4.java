package Aula3;
import java.util.Scanner;
import java.lang.Math;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double ctr = 0, n, max = 0;

        while (true) {
            System.out.print("Número Real? ");
            n = sc.nextDouble();
            if (ctr == 0){
                ctr = n;
                max = n;
            } else {
                if (ctr == n) {
                    break;
                }
            }
            double newmax = Math.max(n, max);
            max = newmax;
            
        }

        System.out.println(max);

        sc.close();

    }
}