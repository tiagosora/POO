package Aula3;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = -1;

        while (N <= 0){
            System.out.print("Número inteiro positivo?  ");
            N = sc.nextInt();
        }
        
        if (N == 2 || N == 3 || N == 5 || N == 7 )  {
            System.out.print(N + " é um número primo!");
        }
        else {
            for (int i= 2; i<=7; i++){
                if (N%i == 0) {
                    System.out.print(N + " não é um número primo!");
                    break;
                }
                if (i==7 && ((N%7)!= 0)){
                    System.out.print(N + " é um número primo!");
                }
            }
        }
        


        sc.close();      

        
    }
}
