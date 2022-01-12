package Aula13;

public class Piloto {
    String pos, driver, nationality, car, pts;

    public Piloto(String pos, String driver, String nationality, String car, String pts){
        this.pos = pos;
        this.driver = driver;
        this.nationality = nationality;
        this.car = car;
        this.pts = pts;
    }
    public String getCar() {
        return car;
    }
    public String getDriver() {
        return driver;
    }
    public String getNationality() {
        return nationality;
    }
    public String getPos() {
        return pos;
    }
    public String getPts() {
        return pts;
    }
    public void setCar(String car) {
        this.car = car;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setPos(String pos) {
        this.pos = pos;
    }
    public void setPts(String pts) {
        this.pts = pts;
    }

    @Override
    public String toString(){
        return this.pos + "; " + this.driver + "; " + this.nationality + "; " + this.car + "; " + this.pts + ". ";
    }
}
