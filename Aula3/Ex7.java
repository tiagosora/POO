package Aula3;
import java.util.Scanner; 
import java.util.Random;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resposta;

        do {
            Random rand = new Random();
            int random_number = rand.nextInt(100);
            int number_of_attempts = 0;
            while (true) {
                System.out.print("Número? ");
                int number = sc.nextInt();
                if (number > random_number) {
                    System.out.println("Alto");
                    number_of_attempts++;
                } else {
                    if (number < random_number) {
                        System.out.println("Baixo");
                        number_of_attempts++;
                    } else {
                        number_of_attempts++;
                        System.out.println("Acertáste em " + number_of_attempts + " tentativas.");
                        break;
                    }
                }
            }
            System.out.print("Pretende continuar? Prima (S)im! ");
            resposta = sc.next();
            
        } while("Sim".equals(resposta) || "S".equals(resposta));
        
        System.out.println("Programa terminado");
        sc.close();
        
    }
    
}
