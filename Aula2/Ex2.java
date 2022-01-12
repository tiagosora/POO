package Aula2;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Célsius? ");
        double c = sc.nextDouble(), f = c*1.8 + 32;
        System.out.println(c + "º Célsius = " + f + " º Fahrenheit");

        sc.close();

    }
}