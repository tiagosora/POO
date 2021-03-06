package Aula8;


public class PratoVegetariano extends Prato implements Vegetariano{
    public PratoVegetariano(String nome) {
        super(nome);
    }
    public boolean addIngrediente(Alimento a){
        if(!(a instanceof Vegetariano))
            return false;
        return super.addIngrediente(a);
    }

    @Override
    public String toString() {
        return "Vegetariano "+super.toString();
    }
}