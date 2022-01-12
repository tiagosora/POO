package Aula7;

public class Hotel extends Housing {
    private Type type;
    private enum Type{
        singlebed, doublebed, twin, triple
    }

    public Hotel(String code, String name, String location, double price, String type){
        super(code, name, location, price);
        try {
            this.type = Hotel.Type.valueOf(type.toLowerCase());
        } catch (java.lang.IllegalArgumentException typIllegalArgumentException) {
            this.type = null;
        }
    }

    public Type getType() {
        return type;
    }
    public void setType(String type) {
        this.type = Hotel.Type.valueOf(type);
    }

    @Override
    public String toString(){
        String nType;
        if (type == null){nType = "";} else {nType = "Tipo: " + type.toString() + "; ";}
        return super.toString() + nType;
    }
}
