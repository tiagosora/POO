package Aula10;
import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        char[] coisa = ("Hello World").toCharArray();
        System.out.println(coisa);
        Map<Character, ArrayList<Integer>> coisa2 = new HashMap<>();
        for(int i = 0; i < coisa.length; i++){
            coisa2.putIfAbsent(coisa[i], new ArrayList<Integer>());
            coisa2.get(coisa[i]).add(i);
        }
        System.out.println(coisa2);
        
    }
}
