package Aula7;

public class Car extends Agency {
    private int code;
    private char carClass;
    private CarFuel carFuel;
    private boolean availability = true;
    private char[] charArray ={ 'A', 'B', 'C', 'D', 'E', 'F' };
    private static int count = 0;
    private enum CarFuel{
        gasoline, diesel
    }

    public Car(char carClass, String carFuel){
        this.code = count;
        count++;
        int checker = 0;
        for (char c : charArray){
            if (c == Character.toUpperCase(carClass)){
                checker = 1;
            }
        }
        if (checker == 1){
            this.carClass = carClass;
        } else {
            this.carClass = '\u0000';
        }
        try{
            this.carFuel = Car.CarFuel.valueOf(carFuel.toLowerCase());
        } catch (java.lang.IllegalArgumentException carFuelIllegalArgumentException){
            this.carFuel = null;
        }
    }
    public int getCode() {
        return code;
    }
    public char getCarClass() {
        return carClass;
    }
    public CarFuel getCarFuel() {
        return carFuel;
    }
    public boolean getAvailability(){
        return availability;
    }
    public void setCarClass(char carClass) {
        this.carClass = carClass;
    }
    public void setCarFuel(String carFuel) {
        this.carFuel = Car.CarFuel.valueOf(carFuel);
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString(){
        String carClassString = "Classe: " + String.valueOf(carClass) + "; ",
        carFuelString, availabilityString;
        if (carClass == '\u0000'){carClassString = "";}
        if (carFuel == null){carFuelString = "";} else {carFuelString = "Combustível: " + carFuel.toString() + "; ";}
        if (availability == true){availabilityString = "Disponibilidade: true;";}else{availabilityString = "Disponibilidade: false;";}
        return "Código: " + code + "; " + carClassString + carFuelString + availabilityString;
    }
}
