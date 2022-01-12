package Aula13;
import java.util.*;
import java.io.*;

public class programa {
    public static Scanner input;
    public static PrintWriter printWriter;
    public static void main(String[] args) throws FileNotFoundException {
        //1
        input = new Scanner(new File("src/Aula13/F12019.txt"));
        input.nextLine();
        List<Piloto> list = new ArrayList<>();
        while (input.hasNext()){
            String[] p = input.nextLine().split("\t");
            list.add(new Piloto(p[0], p[1], p[2], p[3], p[4]));
        }
        input.close();
        System.out.println("\n1)");
        printList(list);
        //2
        list.stream().forEach(e -> e.setDriver(e.getDriver().toUpperCase()));
        System.out.println("\n2)");
        printList(list);
        //3
        list.stream().sorted(Comparator.comparing(e -> e.getNationality()));
        System.out.println("\n3)");
        printList(list);
        //4
        list.stream().sorted(Comparator.comparing(e -> Integer.parseInt(e.getPts())));
        System.out.println("\n4)");
        printList(list);
    }
    public static void printList(List<Piloto> l){
        l.forEach(System.out::println);
    }
}
