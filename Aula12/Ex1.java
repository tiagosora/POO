package Aula12;
import java.io.*;
import java.util.*;

public class Ex1 {
    public static PrintWriter printWriter;
    public static Scanner input;
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        //I will be using the file from class11 major.txt
        input = new Scanner(new File("src/Aula12/major.txt"));
        while(input.hasNext()){
            List<String> splited = Arrays.asList(input.next().split("\\W"));
            splited.forEach(e->{
                set.add(e);
                list.add(e);
            });
        }
        System.out.println("\nNo ficheiro major.txt temos os seguintes numeros de palavras.\n");
        System.out.println("Número Total de Palavras: " + Integer.toString(list.size()));
        System.out.println("Número de Diferentes Palavras: " + Integer.toString(set.size()) + "\n");
    }
}
