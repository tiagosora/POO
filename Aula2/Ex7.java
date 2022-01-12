package Aula2;
import java.util.Scanner;
import java.lang.Math;

public class Ex7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("x1? ");
        double x1 = sc.nextDouble();
        System.out.print("y1? ");
        double y1 = sc.nextDouble();
        System.out.print("x2? ");
        double x2 = sc.nextDouble();
        System.out.print("y2? ");
        double y2 = sc.nextDouble();

        double x = x1 + x2;
        double y = y1 + y2;
        double d = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));

        System.out.println("Distance: "+d);

        sc.close();
    }
}
