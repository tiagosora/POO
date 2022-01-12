package Aula6;
import java.util.Scanner;

public class Ex2 {
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
        System.out.print("Cor? ");
        String rgb = sc.next();
        sc.nextLine();
        Retangulo ret = new Retangulo(c,l,rgb);
        System.out.println("O seu retangulo tem área " + ret.area() + ", perimetro " + ret.perimetro() + " e cor " + ret.getCor() +".");

        System.out.println("Crie um triângulo!");
        double[] lados = ladosTriangulo();
        while (lados[0] + lados[1] <= lados[2] || lados[2] + lados[1] <= lados[0] || lados[0] + lados[2] <= lados[1]) {
            System.out.println("Impossivel criar o triangulo. Tente com outras medidas.");
            lados = ladosTriangulo();
        }
        System.out.print("Cor? ");
        String rgb1 = sc.next();
        sc.nextLine();
        Triangulo trig = new Triangulo(lados[2],lados[0],lados[1],rgb1);
        if (trig != null) {
            System.out.println("O seu triangulo tem área " + trig.area() + ", perimetro " + trig.perimetro() + " e cor " + trig.getCor() +".");
        }

        System.out.println("O retângulo e o triângulo " + (ret.getCor().equals(trig.getCor()) ? "" : "não ") + "têm a mesma cor!");

        System.out.println("Crie um circulo!");
        System.out.print("Valor X do centro? ");
        double x1 = sc.nextDouble();
        System.out.print("Valor Y do centro? ");
        double y1 = sc.nextDouble();
        System.out.print("Raio? ");
        double r1 = sc.nextDouble();
        System.out.print("Cor? ");
        String rgb2 = sc.next();
        sc.nextLine();
        Circulo c1 = new Circulo(new Ponto(x1,y1),r1,rgb2);
        System.out.println("O seu circulo tem centro C(" + c1.getCentro().getX() + "," + c1.getCentro().getY() + "). Área = " + c1.area() + ". Perimetro = " + c1.perimetro() + ". Cor = " + c1.getCor());

        System.out.println("Crie outro circulo!");
        System.out.print("Valor X do centro? ");
        double x2 = sc.nextDouble();
        System.out.print("Valor Y do centro? ");
        double y2 = sc.nextDouble();
        System.out.print("Raio? ");
        double r2 = sc.nextDouble();
        System.out.print("Cor? ");
        String rgb3 = sc.next();
        sc.nextLine();
        Circulo c2 = new Circulo(new Ponto(x2,y2),r2,rgb3);
        System.out.print("Os circulos " + (c1.intersetaCirculo(c2) ? "intersetam-se." : "não se intersetam."));

        sc.close();
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
