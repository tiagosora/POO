package Aula11;
import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Ex1 {
    public static Map<String, Map<String, Integer>> pares = new HashMap<>();
    public static PrintWriter printWriter;
    public static Scanner input;
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        input = new Scanner(new File("src/Aula11/major.txt"));
        while(input.hasNext()){
            String[] r = input.next().split("\\W");
            for(int i = 0; i < r.length; i++){
                if(r[i].length()>2){
                    words.add(r[i]);
                }
            }
        }
        for(int i = 0; i < words.size(); i++){
            pares.putIfAbsent(words.get(i), new HashMap<>());
            if ((i+1) < words.size()){
                pares.get(words.get(i)).putIfAbsent(words.get(i+1), 0);
                pares.get(words.get(i)).put(words.get(i+1), pares.get(words.get(i)).get(words.get(i+1)) + 1);
            }
        }
        TreeMap<String, Map<String, Integer>> paresSortedMap = new TreeMap<>(pares);
        for(Entry<String, Map<String, Integer>> ele : paresSortedMap.entrySet()){
            System.out.println(ele);
        }
    }
    
}
