package Aula11;
import java.io.*;
import java.util.*;
import java.util.Map.*;
import java.util.stream.*;


public class Ex2 {
    public static PrintWriter printWriter;
    public static Scanner input;
    public static void main(String[] args) throws FileNotFoundException {
        //a
        ArrayList<Voo> ListaVoos = new ArrayList<>();
        Map<String, String> companhias = new HashMap<>();
        input = new Scanner(new File("src/Aula11/companhias.txt"));
        while(input.hasNextLine()){
            String[] match = input.nextLine().split("\t");
            for(int i = 0; i < match.length; i++){
                companhias.put(match[0], match[1]);
            }
        }
        input.close();
        input = new Scanner(new File("src/Aula11/voos.txt"));
        while(input.hasNextLine()){
            String[] match = input.nextLine().split("\t");
            String comp = match[1].substring(0, 2);
            try{
                ListaVoos.add(new Voo(match[0], match[1], companhias.get(comp), match[2], match[3]));
            } catch(ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException){
                ListaVoos.add(new Voo(match[0], match[1], companhias.get(comp), match[2]));
            }
        }
        input.close();
        System.out.printf("%-7s %-10s %-20s %-20s %-10s %-15s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
        for(int i = 0; i < ListaVoos.size(); i++){
            String AtrasoString = ListaVoos.get(i).getAtraso();
            String ObsString = "Previsto : " + ListaVoos.get(i).getObs();
            if (ListaVoos.get(i).getAtraso().equals("")){AtrasoString = "";}
            if (ListaVoos.get(i).getObs().equals("")){ObsString = "";}
            System.out.printf("%-7s %-10s %-20s %-20s %-10s %-15s\n", ListaVoos.get(i).getHora(), ListaVoos.get(i).getVoo(), 
            ListaVoos.get(i).companhia, ListaVoos.get(i).getOrigem(), AtrasoString, ObsString);
        }
        //b
        printWriter = new PrintWriter(new File("src/Aula11/Infopublico.txt"));
        printWriter.printf("%-7s %-10s %-20s %-20s %-10s %-15s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
        for(int i = 0; i < ListaVoos.size(); i++){
            String AtrasoString = ListaVoos.get(i).getAtraso();
            String ObsString = "Previsto : " + ListaVoos.get(i).getObs();
            if (ListaVoos.get(i).getAtraso().equals("")){AtrasoString = "";}
            if (ListaVoos.get(i).getObs().equals("")){ObsString = "";}
            printWriter.printf("%-7s %-10s %-20s %-20s %-10s %-15s\n", ListaVoos.get(i).getHora(), ListaVoos.get(i).getVoo(), 
            ListaVoos.get(i).companhia, ListaVoos.get(i).getOrigem(), AtrasoString, ObsString);
        }
        printWriter.close();
        //c
        Map<String, double[]> MapAtrasos = new LinkedHashMap<>();
        for(Voo fly : ListaVoos){
            if(!fly.getAtraso().equals("")){
                MapAtrasos.putIfAbsent(fly.getCompanhia(), new double[]{0,0});
                String[] atrasoSplit = fly.getAtraso().split("\\W");
                double d = Double.parseDouble(atrasoSplit[0])*60+Double.parseDouble(atrasoSplit[1]);
                double mk = MapAtrasos.get(fly.getCompanhia())[0] * MapAtrasos.get(fly.getCompanhia())[1];
                MapAtrasos.get(fly.getCompanhia())[0] = (mk + d)/(MapAtrasos.get(fly.getCompanhia())[1] + 1);
                MapAtrasos.get(fly.getCompanhia())[1]++;
            }
        }
        Map<String, double[]> sortedMap = MapAtrasos.entrySet().stream()
        .sorted(Comparator.comparingDouble(e -> e.getValue()[0])).collect(Collectors.toMap(
            Map.Entry::getKey, Map.Entry::getValue, (a, b) -> { throw new AssertionError(); }, LinkedHashMap::new));
        System.out.println("\n");
        System.out.printf("%-20s %-7s\n", "Companhia", "Atraso Médio");
        for(Entry<String, double[]> element : sortedMap.entrySet()){
            String mediaString;

            if((double)element.getValue()[0]/60 < 10){
                if (element.getValue()[0]%60 < 10){
                    mediaString = "0"+Integer.toString((int)element.getValue()[0]/60)+":0"+Integer.toString((int)element.getValue()[0]%60);
                } else {
                    mediaString = "0"+Integer.toString((int)element.getValue()[0]/60)+":"+Integer.toString((int)element.getValue()[0]%60);
                }
            } else{
                if (element.getValue()[0]%60 < 10){
                    mediaString = Integer.toString((int)element.getValue()[0]/60)+":0"+Integer.toString((int)element.getValue()[0]%60);
                } else {
                    mediaString = Integer.toString((int)element.getValue()[0]/60)+":"+Integer.toString((int)element.getValue()[0]%60);
                }
            }
            System.out.printf("%-20s %-7s\n", element.getKey(), mediaString);
        }
        //d
        Map<String, Integer> VooNumb = new HashMap<>();
        for(Voo fly : ListaVoos){
            VooNumb.putIfAbsent(fly.getOrigem(), 0);
            int n = VooNumb.get(fly.getOrigem()) + 1;
            VooNumb.put(fly.getOrigem(), n);
        }
        Map<String, Integer> sortedMapD = VooNumb.entrySet().stream()
        .sorted(Comparator.comparingInt(e -> -e.getValue()))
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a, b) -> { throw new AssertionError(); },
                LinkedHashMap::new
        ));
        System.out.println("\n");
        System.out.printf("%-20s %-7s\n", "Origem", "Voos");
        for(Entry<String, Integer> element : sortedMapD.entrySet()){
            System.out.printf("%-20s %-5s\n", element.getKey(), element.getValue());
        }
    }
}