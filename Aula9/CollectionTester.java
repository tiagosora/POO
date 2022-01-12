package Aula9;
import java.util.*;

public class CollectionTester {
    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>();
        Collection<Integer> au = new LinkedList<>();
        Collection<Integer> tis = new HashSet<>();
        Collection<Integer> mo = new TreeSet<>();
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "Collection", "1000", "5000", "10000", "20000", "40000", "100000");
        System.out.println("ArrayList");
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "add", checkPerformance(col, 1000)[0], checkPerformance(col, 5000)[0], checkPerformance(col, 10000)[0], checkPerformance(col, 20000)[0], checkPerformance(col, 40000)[0], checkPerformance(col, 100000)[0]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "search", checkPerformance(col, 1000)[1], checkPerformance(col, 5000)[1], checkPerformance(col, 10000)[1], checkPerformance(col, 20000)[1], checkPerformance(col, 40000)[1], checkPerformance(col, 100000)[1]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "remove", checkPerformance(col, 1000)[2], checkPerformance(col, 5000)[2], checkPerformance(col, 10000)[2], checkPerformance(col, 20000)[2], checkPerformance(col, 40000)[2], checkPerformance(col, 100000)[2]);
        System.out.println("LinkedList");
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "add", checkPerformance(au, 1000)[0], checkPerformance(au, 5000)[0], checkPerformance(au, 10000)[0], checkPerformance(au, 20000)[0], checkPerformance(au, 40000)[0], checkPerformance(au, 100000)[0]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "search", checkPerformance(au, 1000)[1], checkPerformance(au, 5000)[1], checkPerformance(au, 10000)[1], checkPerformance(au, 20000)[1], checkPerformance(au, 40000)[1], checkPerformance(au, 100000)[1]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "remove", checkPerformance(au, 1000)[2], checkPerformance(au, 5000)[2], checkPerformance(au, 10000)[2], checkPerformance(au, 20000)[2], checkPerformance(au, 40000)[2], checkPerformance(au, 100000)[2]);
        System.out.println("HashSet");
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "add", checkPerformance(tis, 1000)[0], checkPerformance(tis, 5000)[0], checkPerformance(tis, 10000)[0], checkPerformance(tis, 20000)[0], checkPerformance(tis, 40000)[0], checkPerformance(tis, 100000)[0]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "search", checkPerformance(tis, 1000)[1], checkPerformance(tis, 5000)[1], checkPerformance(tis, 10000)[1], checkPerformance(tis, 20000)[1], checkPerformance(tis, 40000)[1], checkPerformance(tis, 100000)[1]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "remove", checkPerformance(tis, 1000)[2], checkPerformance(tis, 5000)[2], checkPerformance(tis, 10000)[2], checkPerformance(tis, 20000)[2], checkPerformance(tis, 40000)[2], checkPerformance(tis, 100000)[2]);    
        System.out.println("TreeSet");
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "add", checkPerformance(mo, 1000)[0], checkPerformance(mo, 5000)[0], checkPerformance(mo, 10000)[0], checkPerformance(mo, 20000)[0], checkPerformance(mo, 40000)[0], checkPerformance(mo, 100000)[0]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "search", checkPerformance(mo, 1000)[1], checkPerformance(mo, 5000)[1], checkPerformance(mo, 10000)[1], checkPerformance(mo, 20000)[1], checkPerformance(mo, 40000)[1], checkPerformance(mo, 100000)[1]);
        System.out.printf("%10s %7s %7s %7s %7s %7s %7s\n", "remove", checkPerformance(mo, 1000)[2], checkPerformance(mo, 5000)[2], checkPerformance(mo, 10000)[2], checkPerformance(mo, 20000)[2], checkPerformance(mo, 40000)[2], checkPerformance(mo, 100000)[2]);    
    
    }
        private static double[] checkPerformance(Collection<Integer> col, int DIM) {
        
        double start, stop, delta1, delta2, delta3;
        // Add
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ )
        col.add( i );
        stop = System.nanoTime(); // clock snapshot after
        delta1 = (stop-start)/1e6; // convert to milliseconds
        // Search
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ ) {
        int n = (int) (Math.random()*DIM);
        if (!col.contains(n))
        System.out.println("Not found???"+n);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta2 = (stop-start)/1e6; // convert nanoseconds to milliseconds
        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
         iterator.next();
         iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta3 = (stop-start)/1e6; // convert nanoseconds to milliseconds

        double[] depre = {delta1, delta2, delta3};
        return depre;
        }
        
}
