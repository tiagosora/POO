package Aula10;
import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input;
        PrintWriter banana;
        banana = new PrintWriter(new File("src/Aula10/wordswriter.txt"));

        input = new Scanner(new File("src/Aula10/words.txt"));
        while(input.hasNext()){
            String word = input.next();
            System.out.println(word);
            if(word.length() > 2){
                banana.println(word);
            }
        }
        banana.println();

        input = new Scanner(new File("src/Aula10/words.txt"));
        while(input.hasNext()){
            String word = input.next();
            if(word.endsWith("s")){
                banana.println(word);
            }
        }
        banana.println();
        input.close();
        banana.close();

        input = new Scanner(new File("src/Aula10/wordswriter.txt"));
        ArrayList<String> wordlist = new ArrayList<>();
        while(input.hasNext()){
            String word = input.next();
            if(word.matches("^[a-zA-Z]+")){
                wordlist.add(word);
            }
        }
        banana = new PrintWriter(new File("src/Aula10/wordswriter.txt"));
        for(String word : wordlist){
            banana.println(word);
        }

        input.close();
        banana.close();
    }
}
