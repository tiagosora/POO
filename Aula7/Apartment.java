package Aula7;

public class Apartment extends Housing{
    private int nRooms;
    
    public Apartment(String code, String name, String location, double price, int nRooms){
        super(code, name, location, price);
        this.nRooms = nRooms;
    }

    public int getNRooms() {
        return nRooms;
    }
    public void setNRooms(int nRooms) {
        this.nRooms = nRooms;
    }
    
    @Override
    public String toString(){
        String nRoomsString = "Quartos: " + String.valueOf(nRooms) + "; ";
        if (nRooms == 0){nRoomsString = "";}
        return super.toString() + nRoomsString;
    }
}