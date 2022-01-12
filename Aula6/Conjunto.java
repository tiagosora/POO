package Aula6;
import java.util.ArrayList;

public class Conjunto {
    private ArrayList<Integer> conjunto = new ArrayList<>();

    public ArrayList<Integer> getConjunto(){
        return conjunto;
    }
    public void insert(int n){
        if (conjunto.contains(n)){}
        else {conjunto.add(n);}
    }
    public boolean contains(int n){
        if (conjunto.contains(n)){return true;}
        else {return false;}
    }
    public void remove(int n){
        for (int i = 0; i < conjunto.size(); i++){
            if (conjunto.get(i) == n){conjunto.remove(i);}
        }
    }
    public void empty(){
        conjunto.clear();
    }
    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < conjunto.size(); i++){
            res += conjunto.get(i) + " ";
        }
        return res;
    }
    public int size(){
        return conjunto.size();
    }
    public Conjunto unir(Conjunto add){
        Conjunto res = new Conjunto();
        for (int i = 0; i < conjunto.size(); i++) {
            res.insert(conjunto.get(i));
        }
        for (int i = 0; i < add.size(); i++) {
            res.insert(add.getConjunto().get(i));
        }
        return res;
    }
    public Conjunto subtrair(Conjunto dif){
        Conjunto res = new Conjunto();
        for (int i = 0; i < conjunto.size(); i++) {
            res.insert(conjunto.get(i));
        }
        for (int i = 0; i < dif.size(); i++) {
            res.remove(dif.getConjunto().get(i));
        }
        return res;
    }
    public Conjunto interset(Conjunto inter){
        Conjunto res = new Conjunto();
        for (int a = 0; a < conjunto.size(); a++) {
            for (int b = 0; b < inter.size(); b++) {
                if (conjunto.get(a) == inter.getConjunto().get(b)) {
                    res.insert(conjunto.get(a));
                }
            }
        }
        return res;
    }
}
