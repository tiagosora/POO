package Aula2;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira um tempo em segundos: ");
        int segundos, minutos, horas, time = sc.nextInt();
        
        if (time >= 60) {
            segundos = time % 60;
            time = (time - segundos) / 60;
            if (time >= 60) {
                minutos = time % 60;
                horas = (time - minutos) / 60;
             } else {
                minutos = time;
                horas = 0;
            }
        } else {
            segundos = time;
            minutos = 0;
            horas = 0;
        }

        String s = String.valueOf(segundos), m = String.valueOf(minutos), h = String.valueOf(horas);
        if (s.length() < 2){s = "0"+s;}
        if (m.length() < 2){m = "0"+m;}
        if (h.length() < 2){h = "0"+h;}
        
        

        System.out.println("Tempo (hh:mm:ss): " + h + ":" + m + ":" + s);

        sc.close();
    }
}
