package Aula3;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mes = -1, ano = -1, dias = 0;

        while (0 >= mes || mes > 12) {
            System.out.print("Mês? ");
            mes = sc.nextInt(); 
        }
        while (-1 >= ano) {
            System.out.print("Ano? ");
            ano = sc.nextInt(); 
        }

        switch (mes) {
            case 1: case 3: case 5: case 6: case 8: case 10: case 12: 
                dias = 31; 
                break;
            case 4: case 7: case 9: case 11:
                dias = 30; 
                break; 
            case 2:
                if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
                    dias = 29;
                }else{
                    dias = 28;
            }
        }

        System.out.println(dias);

        sc.close();
    }
}
