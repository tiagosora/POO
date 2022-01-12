package Aula7;
import java.lang.Math;

public abstract class ObjetoMovel {
    private int x, y;
    private double distanciaPercorrida;

    public ObjetoMovel(int x, int y){
        this.x = x;
        this.y = y;
        this.distanciaPercorrida = 0;
    }

    public void move(int newX, int newY){
        this.distanciaPercorrida += Math.sqrt(Math.pow((newX - this.x), 2)+Math.pow((newY - this.y), 2));
        this.x = newX;
        this.y = newY;
    }
    public void move(int[] xy) {
        this.x = xy[0];
        this.y = xy[1];
        this.distanciaPercorrida += Math.sqrt(Math.pow((xy[0] - this.x), 2)+Math.pow((xy[1] - this.y), 2));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double[] getPosition() {
        return new double[]{x,y};
    }
    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }
    public void setPosition(int[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }
    
    
}
