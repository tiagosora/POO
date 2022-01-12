package Aula5;
import java.util.Scanner;

public class Ex1 {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Create a new point!");
        System.out.print("Valor X? ");
        double x = sc.nextDouble();
        System.out.print("Valor Y? ");
        double y = sc.nextDouble();
        Ponto p1 = new Ponto(x,y);
        System.out.println("O seu ponto é P("+p1.getX()+","+p1.getY()+")");

        System.out.println("Crie um retangulo!");
        System.out.print("Comprimento? ");
        double c = sc.nextDouble();
        System.out.print("Largura? ");
        double l = sc.nextDouble();
        Retangulo ret = new Retangulo(c,l);
        System.out.println("O seu retangulo tem área " + ret.area() + " e perimetro " + ret.perimetro() + ".");

        System.out.println("Crie um triângulo!");
        double[] lados = ladosTriangulo();
        while (lados[0] + lados[1] <= lados[2] || lados[2] + lados[1] <= lados[0] || lados[0] + lados[2] <= lados[1]) {
            System.out.println("Impossivel criar o triangulo. Tente com outras medidas.");
            lados = ladosTriangulo();
        }
        Triangulo trig = new Triangulo(lados[2],lados[0],lados[1]);
        if (trig != null) {
            System.out.println("O seu triangulo tem área " + trig.area() + " e perimetro " + trig.perimetro() + ".");
        }

        System.out.println("Crie um circulo!");
        System.out.print("Valor X do centro? ");
        double x1 = sc.nextDouble();
        System.out.print("Valor Y do centro? ");
        double y1 = sc.nextDouble();
        System.out.print("Raio? ");
        double r1 = sc.nextDouble();
        Circulo c1 = new Circulo(new Ponto(x1,y1), r1);
        System.out.println("O seu circulo tem centro C(" + c1.getCentro().getX() + "," + c1.getCentro().getY() + "). Área = " + c1.area() + ". Perimetro = " + c1.perimetro() + ".");

        System.out.println("Crie outro circulo!");
        System.out.print("Valor X do centro? ");
        double x2 = sc.nextDouble();
        System.out.print("Valor Y do centro? ");
        double y2 = sc.nextDouble();
        System.out.print("Raio? ");
        double r2 = sc.nextDouble();
        Circulo c2 = new Circulo(new Ponto(x2,y2), r2);
        System.out.print("Os circulos " + (c1.intersetaCirculo(c2) ? "intersetam-se." : "não se intersetam."));

    }
    public static double[] ladosTriangulo() {
        
        
        System.out.print("Lado 1? ");
        double lado1 = sc.nextDouble();
        System.out.print("Lado 2? ");
        double lado2 = sc.nextDouble();
        System.out.print("Lado 3? ");
        double lado3 = sc.nextDouble();
        double[] lados = {lado1, lado2, lado3};

        return lados;   
    }
}
