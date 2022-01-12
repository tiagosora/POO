package Aula9;
import java.util.*;

public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        
        for (int i = 10; i <= 100; i+=10) {
            c1.add(i);
        }
        
        System.out.println("Size: " + c1.size());
        
        for (int i = 0; i < c1.size(); i++) {
            System.out.println("Elemento: " + c1.get(i));
        }

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);

        //a)
        c1.add(200);
        System.out.println(c1.contains(200) ? "Contém 200 no index: " + c1.indexOf(200) : "Não contém 200" );
        c1.add(10);
        int count = 0;
        for (int n : c1){
            if(n == 10){
                count++;
            }
        }
        System.out.println("O número 10 existe " + count  +  " vezes na lista! Na posiçao " + c1.indexOf(10) + " e na posição " + c1.lastIndexOf(10));
        System.out.println("Index 4, número: " + c1.get(4));
        c1.set(4, 24);
        System.out.println("Index 4, número: " + c1.get(4));
        System.out.print("List: ");
        System.out.println(c1);
        System.out.print("Sublist (0, 3): ");
        System.out.println(c1.subList(0, 3));

        //b)
        Set<Pessoa> c3 = new HashSet<>();
        Pessoa a = new Pessoa("Ana", 1, new Data(1,1,1));
        c3.add(a);
        c3.add(new Pessoa("Maria", 2, new Data(2,2,2)));
        c3.add(new Pessoa("Joana", 3, new Data(3,3,3)));
        c3.add(new Pessoa("Joao", 4, new Data(4,4,4)));
        c3.add(new Pessoa("Alberta", 5, new Data(5,5,5)));
        System.out.println("HashSet: " + c3);
        c3.add(a);
        System.out.println("HashSet: " + c3);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("viagem");
        ts.add("calendário");
        ts.add("prova");
        ts.add("zircórnio");
        ts.add("ilha do sal");
        ts.add("avião");
        System.out.println("TreeSet: " + ts);

        Set<Data> c4 = new TreeSet<>();
        c4.add(new Data(1,1,1));
        c4.add(new Data(2,2,2));
        c4.add(new Data(3,3,3));
        c4.add(new Data(4,4,4));
        c4.add(new Data(5,5,5));
        System.out.println("TreeSet: " + c4);



    }
}