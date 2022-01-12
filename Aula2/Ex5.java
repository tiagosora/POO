package Aula2;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("d1? (m) ");
        double d1 = sc.nextDouble();
        System.out.print("t1? (s) ");
        double t1 = sc.nextDouble();
        System.out.print("d2? (m) ");
        double d2 = sc.nextDouble();
        System.out.print("t2? (s) ");
        double t2 = sc.nextDouble();

        double df = d1 + d2;
        double tf = t1 + t2;

        double vm = df/tf;
        System.out.println("Velocidade Média: " + vm + " m/s");

        sc.close();
    }
}
