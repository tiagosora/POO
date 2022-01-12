package Aula7;
import java.util.Scanner;
import java.util.ArrayList;
public class Ex1 {
    public static final Scanner sc = new Scanner(System.in);
    public static ArrayList<Car> cars = new ArrayList<>();
    public static ArrayList<Apartment> apartments = new ArrayList<>();
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    public static Agency agency = new Agency();
    public static void main(String[] args) {
        int n;
        System.out.println("\n\nMenu");
        System.out.println(
        "1  - imprimir informaçoes da agencia\n" +
        "2  - adicionar um alojamento\n" +
        "3  - remover um alojamento\n" +
        "4  - avaliar um alojamento\n" +
        "5  - imprimir lista de apartamentos/hoteis\n" +
        "6  - imprimir lista de apartamentos/hoteis disponiveis\n" +
        "7  - fazer um check-in\n" +
        "8  - fazer um check-out\n" +
        "9  - adicionar um carro\n" +
        "10 - remover um carro\n" +
        "11 - lista de carros\n" +
        "12 - lista de carros disponiveis\n" +
        "13 - levantar um carro\n" +
        "14 - entregar um carro\n" +
        "15 - sair\n"
        );
        System.out.print("Selecione uma das opções (1-10) ");
        try {
            n = sc.nextInt();
            sc.nextLine();
            action(n);
        } catch (java.util.InputMismatchException nInputMismatchException) {
            sc.nextLine();
            System.out.println("\nIntroduza um valor aceitável!");
            main(null);
        }
    }
    public static void action(int n){
        switch (n) {
            case 1: 
                printAgency();
                main(null);
                break;
            case 2: 
                addHousing();
                main(null);
                break;
            case 3:
                removeHousing(); 
                main(null);
                break;
            case 4:
                rateHousing();
                main(null);
                break;
            case 5:
                printHousing(); 
                main(null);
                break;
            case 6:
                printAvailableHousing();
                main(null);
                break;
            case 7:
                checkin(); 
                main(null);
                break;
            case 8:
                checkout(); 
                main(null);
                break;
            case 9:
                addCar(); 
                main(null);
                break;
            case 10:
                removeCar();
                main(null);
                break;
            case 11:
                printCars();
                main(null);
                break;
            case 12:
                printAvailableCars();
                main(null);
                break;
            case 13:
                borrowCar();
                main(null);
                break;
            case 14:
                refundCar();
                main(null);
                break;
            case 15:
                System.out.println("\nO programa foi encerrado com sucesso!");
                sc.close(); 
                System.exit(0);
            default:
                System.out.println("\nIntroduza um valor aceitável!");
                main(null);
                break;
        }
    }
    public static boolean checkMultipleCodes(String code){
        if (code != null) {
            int checker = 0;
            for (int i = 0; i < apartments.size(); i++){
                if (apartments.get(i).getCode().equals(code)){
                    checker = 1;
                }
            }
            for (int i = 0; i < hotels.size(); i++){
                if (hotels.get(i).getCode().equals(code)){
                    checker = 1;
                }
            }
            if (checker == 0){
                return true;
            } else {
                System.out.println("Código em uso! Tente introduzir outro código!");
                return false;
            }
        } else {
            return false;
        }
    }
    public static void printAgency(){
        System.out.println("\n" + agency);
        System.out.println("Number of cars registered: " + cars.size());
        System.out.println("Number of housing registered: " + (apartments.size() + hotels.size()));
    }
    public static void addHousing(){
        int n;
        System.out.println("\nTipo de Alojamento\n" +
        "1 - Apartamento\n" +
        "2 - Hotel\n"
        );
        System.out.print("Que tipo de alojamento deseja registar? ");
        try {
            n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    addApartment();
                    break;
                case 2:
                    addHotel();
                    break;
                default:
                    System.out.println("Introduza um valor aceitável!");
                    addHousing();
                    break;
            }
        } catch (java.util.InputMismatchException priceInputMismatchException) {
            sc.nextLine();
            System.out.println("Introduza um valor aceitável!");
            addHousing();
        }
        
    }
    public static void addApartment(){
        String code;
        double price;
        int nRooms;
        do {
            System.out.print("Código? ");
            code = sc.next();
            sc.nextLine();
        } while (checkMultipleCodes(code) == false);
        System.out.print("Nome? ");
        String name = sc.nextLine();
        System.out.print("Localização? ");
        String location = sc.nextLine();
        System.out.print("Preço por noite? ");
        try {
            price = sc.nextDouble();
            sc.nextLine();
        } catch (java.util.InputMismatchException InputMismatchException) {
            sc.nextLine();
            price = 0.0;
        }
        System.out.print("Número de Quartos? ");
        try {
            nRooms = sc.nextInt();
            sc.nextLine();
        } catch (java.util.InputMismatchException InputMismatchException) {
            sc.nextLine();
            nRooms = 0;
        }
        apartments.add(new Apartment(code, name, location, price, nRooms));
        System.out.println("Alojamento adicionado com sucesso!");
    }
    public static void addHotel(){
        String code;
        double price;
        do {
            System.out.print("Código? ");
            code = sc.next();
            sc.nextLine();
        } while (checkMultipleCodes(code) == false);
        System.out.print("Nome? ");
        String name = sc.nextLine();
        System.out.print("Localização? ");
        String location = sc.nextLine();
        System.out.print("Preço por noite? ");
        try {
            price = sc.nextDouble();
            sc.nextLine();
        } catch (java.util.InputMismatchException pInputMismatchException) {
            sc.nextLine();
            price = 0.0;
        }
        System.out.print("Tipo de Quarto? (singlebed, doublebed, twin, triple) ");
        String type = sc.next().toLowerCase();
        sc.nextLine();
        hotels.add(new Hotel(code, name, location, price, type));
        System.out.println("Alojamento adicionado com sucesso!");
    }
    public static void removeHousing(){
        System.out.print("Código? ");
        String code = sc.next();
        sc.nextLine();
        int checker = 0;
        for (int i = 0; i < apartments.size(); i++){
            if (apartments.get(i).getCode().equals(code)){
                apartments.remove(i);
                checker = 1;
            }
        }
        for (int i = 0; i < hotels.size(); i++){
            if (hotels.get(i).getCode().equals(code)){
                hotels.remove(i);
                checker = 1;
            }
        }
        if (checker == 1){
            System.out.println("Alojamento removido com sucesso!");
        } else {
            System.out.println("ALERTA: O alojamento não foi encontrado!");
        }
    }
    public static void rateHousing(){
        double rating;
        int checker = 0;
        boolean ctrl = true;
        System.out.print("Código? ");
        String code = sc.next();
        sc.nextLine();
        System.out.print("Avaliação? ");
        try {
            rating = sc.nextDouble();
            sc.nextLine();
            for (int i = 0; i < apartments.size(); i++){
                if (apartments.get(i).getCode().equals(code)){
                    ctrl = apartments.get(i).giveRating(rating);
                    checker = 1;
                }
            }
            for (int i = 0; i < hotels.size(); i++){
                if (hotels.get(i).getCode().equals(code)){
                    ctrl = hotels.get(i).giveRating(rating);
                    checker = 1;
                }
            }
        } catch (java.util.InputMismatchException rInputMismatchException) {
            sc.nextLine();
            System.out.println("Introduza um valor aceitável!");
            rateHousing();
        }
        if (checker == 1){
            if (ctrl == true) {
                System.out.println("Avaliação feita com sucesso!");
            } else {
            System.out.println("ALERTA! O valor deve estar entre 0 e 5!");
            rateHousing();
            }
        } else {
            System.out.println("ALERTA: O alojamento não foi encontrado!");
        }
    }
    public static void printHousing(){
        System.out.println("\n-Apartamentos-");
        for (int i = 0; i < apartments.size(); i++){
            System.out.println(apartments.get(i));
        }
        System.out.println("\n-Hoteis-");
        for (int i = 0; i < hotels.size(); i++){
            System.out.println(hotels.get(i));
        }  
    }
    public static void printAvailableHousing(){
        System.out.println("\n-Apartamentos-");
        for (int i = 0; i < apartments.size(); i++){
            if (apartments.get(i).getAvailability() == true){
                System.out.println(apartments.get(i));
            }
        }
        System.out.println("\n-Hoteis-");
        for (int i = 0; i < hotels.size(); i++){
            if (hotels.get(i).getAvailability() == true){
                System.out.println(hotels.get(i));
            }
        }
    }
    public static void checkin(){
        System.out.print("Código? ");
        String code = sc.nextLine();

        int checker = 0;
        for (int i = 0; i < apartments.size(); i++){
            if (apartments.get(i).getCode().equals(code)){
                if (apartments.get(i).getAvailability() == true) {
                    apartments.get(i).setAvailability(false);
                    checker = 1;
                } else {
                    checker = 2;
                    System.out.print("O alojamento não se encontra disponível!");
                }
            }
        }
        for (int i = 0; i < hotels.size(); i++){
            if (hotels.get(i).getCode().equals(code)){
                if (hotels.get(i).getAvailability() == true) {
                    hotels.get(i).setAvailability(false);
                    checker = 1;
                } else {
                    checker = 2;
                    System.out.print("O alojamento não se encontra disponível!");
                }
            }
        }
        if (checker == 1){
            System.out.println("Check-in feito com sucesso!");
        } else if (checker == 0){
            System.out.println("ALERTA: O alojamento não foi encontrado!");
        }
    }
    public static void checkout(){
        System.out.print("Código? ");
        String code = sc.nextLine();
        int checker = 0;
        for (int i = 0; i < apartments.size(); i++){
            if (apartments.get(i).getCode().equals(code)){
                if (apartments.get(i).getAvailability() == false) {
                    apartments.get(i).setAvailability(true);
                    checker = 1;
                } else {
                    checker = 2;
                    System.out.print("O alojamento não se encontra indisponível!");
                }
            }
        }
        for (int i = 0; i < hotels.size(); i++){
            if (hotels.get(i).getCode().equals(code)){
                if (hotels.get(i).getAvailability() == false) {
                    hotels.get(i).setAvailability(true);
                    checker = 1;
                } else {
                    checker = 2;
                    System.out.print("O alojamento não se encontra indisponível!");
                }
            }
        }
        if (checker == 1){
            System.out.println("Check-out feito com sucesso!");
        } else if (checker == 0){
            System.out.println("ALERTA: O alojamento não foi encontrado!");
        }
    }
    public static void addCar(){
        System.out.print("Classe do carro? ");
        char carClass = sc.nextLine().charAt(0);
        System.out.print("Combustível? (Gasoline/Diesel) ");
        String carFuel = sc.next().toLowerCase();
        sc.nextLine();
        cars.add(new Car(Character.toUpperCase(carClass), carFuel));
        System.out.println("Carro adicionado com sucesso!");
    }
    public static void removeCar(){
        System.out.print("Código? ");
        int code = sc.nextInt();
        sc.nextLine();
        int checker = 0;
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getCode() == code){
                cars.remove(i);
                checker = 1;
            }
        }
        if (checker == 1){
            System.out.println("Carro removido com sucesso!");
        } else {
            System.out.println("ALERTA: O carro não foi encontrado!");
        }
    }
    public static void printCars(){
        System.out.println("\n-Início-");
        for (int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i));
        } 
        System.out.println("-Fim-");
    }
    public static void printAvailableCars(){
        System.out.println("\n-Início-");
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getAvailability() == true){
                System.out.println(cars.get(i));
            }
        }
        System.out.println("-Fim-"); 
    }
    public static void borrowCar(){
        System.out.print("Código? ");
        int code = sc.nextInt();
        sc.nextLine();
        int checker = 0;
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getCode() == code){
                if (cars.get(i).getAvailability() == true) {
                    cars.get(i).setAvailability(false);
                    checker = 1;
                } else {
                    checker = 2;
                    System.out.print("O carro não se encontra disponível!");
                }            
            }
        }
        if (checker == 1){
            System.out.println("Carro emprestado com sucesso!");
        } else if (checker == 0){
            System.out.println("ALERTA: O carro não foi encontrado!");
        }
    }
    public static void refundCar(){
        System.out.print("Código? ");
        int code = sc.nextInt();
        sc.nextLine();
        int checker = 0;
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getCode() == code){
                if (cars.get(i).getAvailability() == false) {
                    cars.get(i).setAvailability(true);
                    checker = 1;
                } else {
                    checker = 2;
                    System.out.print("O carro não se encontra indisponível!");
                }
            }
        }
        if (checker == 1){
            System.out.println("Carro devolvido com sucesso!");
        } else if (checker == 0){
            System.out.println("ALERTA: O carro não foi encontrado!");
        }
    }
}