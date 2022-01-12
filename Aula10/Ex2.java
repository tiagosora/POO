package Aula10;
import java.io.*;
import java.util.*;

public class Ex2 {
    public static Map<String, String[]> data = new HashMap<>();
    public static PrintWriter printWriter;
    public static Scanner input;
    public static void main(String[] args) throws Exception {
        //a
        data.put("Banana", new String[]{"Fruto da bananeira, geralmente amarelo e oblongo, de casca espessa, polpa mole e doce","vento0"});
        data.put("Gelado", new String[]{"Sobremesa congelada, doce e aromatizada, feita geralmente de água, leite ou sumo de frutas","vento1"});
        data.put("Livro", new String[]{"Conjunto de folhas de papel, em branco, escritas ou impressas, soltas ou cosidas, em brochura ou encadernadas","vento2"});
        data.put("Caixa", new String[]{"Qualquer recipiente rígido usado para guardar ou transportar alguma coisa","vento3"});
        data.put("Computador", new String[]{"Aparelho electrónico usado para processar, guardar e tornar acessível informação de variados tipos","vento4"});
        data.remove("Gelado");
        data.remove("Papel");
        data.put("Papel", new String[]{"Sem descrição estou com preguiça","vento5"});
        Map<String, String[]> sortedData = new TreeMap<>(data);
        
        printWriter = new PrintWriter(new File("src/Aula10/Ex1.txt"));
        for (Map.Entry<String, String[]> element : sortedData.entrySet()){
            printWriter.println(element.getKey());
            for (String a : element.getValue()){
                printWriter.print(a.toString());
            }
            printWriter.println();
        }
        printWriter.close();

        //b
        Scanner sc = new Scanner(System.in);
        System.out.print("Coisa? ");
        String res = sc.next();
        sc.nextLine();
        int i = (int)(Math.random() * data.get(res).length);
        System.out.println(data.get(res)[i]);



        sc.close();
        
    }
}
