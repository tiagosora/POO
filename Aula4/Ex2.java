package Aula4;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String? ");
        String s = sc.nextLine();

        System.out.println(countDigits(s));

        checkLowerCase(s);

        System.out.println(countSpaces(s));

        System.out.println(deleteDoubleSpaces(s));
        
        checkPalindromes(s);

        sc.close();
    }
    public static int countDigits(String s) {
        return s.replaceAll("\\D", "").length();
    }

    public static int countSpaces(String s) {
        return s.replaceAll("[^ ]", "").length();
    }

    public static void checkLowerCase(String s) {
        int ctr = 0;
        for (int i = 0; i < s.length(); i++){
            if (Character.isUpperCase(s.charAt(i))){
                ctr++;
            }
        }
        if (ctr > 0){
            System.out.println("There Are Some Upper Cases");
            
        } else {
            System.out.println("All Lower Cases");
            
        }
    }
    
    public static String deleteDoubleSpaces(String s) {
        return s.trim().replaceAll(" +", " ");
    }

    public static void checkPalindromes(String s) {
        int ctr = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(s.length()-i-1)){
                ctr++;
            }
        }
        if (ctr == s.length()){
            System.out.println("It's a palindrome!");
            
        } else {
            System.out.println("It's not a palindrome!");
        }
        
        

    }
}
