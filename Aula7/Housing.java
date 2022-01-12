package Aula7;

public abstract class Housing extends Agency { 
    private String code;
    private String name;
    private String location;
    private double price;
    private boolean availability = true;
    private double rating;
    private static int ratingCount = 0;

    public Housing(String code, String name, String location, double price){
        this.code = code;
        this.name = name;
        this.location = location;
        this.price = price;
        this.rating = 0.0;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public double getPrice() {
        return price;
    }
    public boolean getAvailability(){
        return availability;
    }
    public double getRating() {
        return rating;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public boolean giveRating(double rating){
        if (0 <= rating && rating <= 5) {
            double value = this.rating * ratingCount;
            ratingCount++;
            this.rating = (value + rating)/ratingCount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        String codeString = "Código: " + code + "; ",
        nameString = "Nome: " + name + "; ",
        locationString = "Localização: " + location + "; ",
        availabilityString,
        priceString = "Preço: " + String.valueOf(price) + "; ",
        ratingString = "Avaliação: " + String.valueOf(rating) + "; ";
        if (code == null){codeString = "";}
        if (name == null){nameString = "";}
        if (location == null){locationString = "";}
        if (availability == true){availabilityString = "Disponibilidade: true; ";} else {availabilityString = "Disponibilidade: false; ";}
        if (price == 0){priceString = "";}
        if (rating == 0.0){ratingString = "";}
        return codeString + nameString + locationString + availabilityString + priceString + ratingString ;
    }
}
