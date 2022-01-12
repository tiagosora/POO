package Aula4;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza uma frase:");
        String str = sc.nextLine(); 
        System.out.println("Acrónimo: " + acronym(str));

        sc.close();
    }

    public static String acronym(String s) {
        StringBuilder ans = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++){
            if (split[i].length() > 3) {
                ans.append(split[i].charAt(0));
            }
        }
        
        return ans.toString().toUpperCase().substring(0,3);
    }
}
