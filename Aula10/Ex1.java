package Aula10;
import java.io.*;
import java.util.*;

public class Ex1 {
    public static Map<String, String> data = new HashMap<>();
    public static PrintWriter printWriter;
    public static Scanner input;
    public static void main(String[] args) throws Exception {
        //a
        data.put("Banana", "Fruto da bananeira, geralmente amarelo e oblongo, de casca espessa, polpa mole e doce");
        data.put("Gelado", "Sobremesa congelada, doce e aromatizada, feita geralmente de água, leite ou sumo de frutas");
        data.put("Livro","Conjunto de folhas de papel, em branco, escritas ou impressas, soltas ou cosidas, em brochura ou encadernadas");
        data.put("Caixa","Qualquer recipiente rígido usado para guardar ou transportar alguma coisa");
        data.put("Computador","Aparelho electrónico usado para processar, guardar e tornar acessível informação de variados tipos");
        data.remove("Gelado");
        data.remove("Papel");
        data.put("Papel","Sem descrição estou com preguiça");
        Map<String, String> sortedData = new TreeMap<>(data);
        
        printWriter = new PrintWriter(new File("src/Aula10/Ex1.txt"));
        for (Map.Entry<String, String> element : sortedData.entrySet()){
            printWriter.println(element.getKey());
            printWriter.println(element.getValue());
        }
        printWriter.close();

        //b
        readfile();
        
    }
    public static void readfile() throws Exception{
        ArrayList<String> fileLines = new ArrayList<>();
        input = new Scanner(new File("src/Aula10/Ex1.txt"));
        while (input.hasNextLine()){
            fileLines.add(input.nextLine());
        }
        System.out.println("Entries");
        for (int i = 0; i < fileLines.size(); i += 2){
            System.out.println(fileLines.get(i)+": "+fileLines.get(i+1));
        }
        System.out.println("\nKeys");
        for (int i = 0; i < fileLines.size(); i += 2){
            System.out.println(fileLines.get(i));
        }
        System.out.println("\nValues");
        for (int i = 1; i < fileLines.size(); i += 2){
            System.out.println(fileLines.get(i));
        }
        input.close();
    }
}
