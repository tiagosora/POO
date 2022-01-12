package Aula2;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quilómetros? ");
        double quilometros = sc.nextDouble();
        double milhas = quilometros/1.609;
        System.out.println(quilometros + "km = " + milhas + " milhas");

        sc.close();
    }
}
