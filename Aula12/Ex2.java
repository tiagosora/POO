package Aula12;
import java.io.*;
import java.util.*;

public class Ex2 {
    public static PrintWriter printWriter;
    public static Scanner input;
    public static void main(String[] args) throws FileNotFoundException {
        //a
        System.out.println("\na)");
        List<Movie> ListaMovies = new ArrayList<>();
        input = new Scanner(new File("src/Aula12/movies.txt"));
        while(input.hasNextLine()){
            String[] splited = input.nextLine().split("\t");
            ListaMovies.add(new Movie(splited[0], splited[1], splited[2], splited[3], splited[4]));
        }
        input.close();
        printlist(ListaMovies);
        //b
        System.out.println("\nb)");
        Collections.sort(ListaMovies, Comparator.comparing(e -> e.getName()));
        printlist(ListaMovies);
        //c
        System.out.println("\nc.1)");
        Collections.sort(ListaMovies, Comparator.comparing(e -> Double.parseDouble(e.getScore())));
        Collections.reverse(ListaMovies);
        printlist(ListaMovies);
        System.out.println("\nc.2)");
        Collections.sort(ListaMovies, Comparator.comparing(e -> Double.parseDouble(e.getRunningTime())));
        printlist(ListaMovies);
        //d
        System.out.println("\nd)");
        Set<String> generos = new HashSet<>();
        ListaMovies.forEach(e -> generos.add(e.getGender()));
        System.out.println("Géneros Disponíveis:");
        generos.forEach(System.out::println);
        //e
        System.out.println("\ne)");
        List<Movie> selectedmovies = new ArrayList<>();
        ListaMovies.forEach(e -> {
            if (Double.parseDouble(e.getScore())>60 && e.getGender().equals("comedy")){
                selectedmovies.add(e);
            } 
        });
        printlist(selectedmovies);
    }
    public static void printlist(List<Movie> list){
        //name	score	rating	gender	running time
        System.out.printf("%-40s %-10s %-10s %-10s %-15s\n", "name", "score", "rating", "gender", "running time");
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%-40s %-10s %-10s %-10s %-15s\n", list.get(i).getName(), list.get(i).getScore(),
            list.get(i).getRating(), list.get(i).getGender(), list.get(i).getRunningTime());
        }
    }
}   