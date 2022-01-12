package Aula2;
import java.util.Scanner;
import java.lang.Math;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cateto A? ");
        Double a = sc.nextDouble();
        System.out.print("Cateto B? ");
        Double b = sc.nextDouble();

        double c = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));

        double r = Math.asin(b/c);

        System.out.println("Hipotenusa: "+c+". Angulo: "+r+".");

        sc.close();
        
    }

}
