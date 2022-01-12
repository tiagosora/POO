package Aula2;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quantidade? ");
        double M = sc.nextDouble();
        System.out.print("Temperatura Inicial? ");
        double initialTemperature = sc.nextDouble();
        System.out.print("Temperatura Final? ");
        double finalTemperature = sc.nextDouble();

        
        double Q = M * (finalTemperature - initialTemperature) * 4184;
        
        //para nao aparecer erro :) help me god
        Q = Q*1;
        //para nao aparecer erro :) help me god

        sc.close();
    }
}
