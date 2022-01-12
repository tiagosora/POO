package Aula4;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String? ");
        String f = sc.nextLine();

        System.out.println(min(f));
        System.out.println(firstThree(f));

        //Outros Métodos 
        System.out.println(f.split("\\W"));
        System.out.println(f.matches("\\w{3,}"));
        for (int i=0; i < f.length(); i++ )
        System.out.print(f.charAt(i) + ", ");
        //Outros Métodos 

        sc.close();

    }
    public static String min(String x) {
        String res = x.toLowerCase();
        return res;
    }

    public static String firstThree(String x){
        String res;
        if (x.length()<3) {
            res = x;
        } else {
            res = x.substring(0, 3);
        }
        return res;
    }
}
