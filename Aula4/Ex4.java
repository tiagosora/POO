package Aula4;
import java.util.Scanner;
import java.lang.String;
public class Ex4 {
    public static void main(String[] args) {
        int[] values = values();
        int d = daysOfTheMonth(values[0], values[1]);
        printResults(d, values[0], values[1], values[2]);
    }
    public static int[] values(){
        Scanner sc = new Scanner(System.in);
        int[] values = new int [3];
        System.out.print("Month? (1-12) ");
        values[0] = sc.nextInt(); 
        System.out.print("Year? ");
        values[1] = sc.nextInt();
        System.out.print("Day The Month Starts? (1-7) ");
        values[2] = sc.nextInt();
        sc.close();
        return values;
    }
    public static int daysOfTheMonth(int m, int y){
        int d = 0;
        switch (m) {
            case 1: case 3: case 5: case 6: case 8: case 10: case 12: 
                d = 31; 
                break;
            case 4: case 7: case 9: case 11:
                d = 30; 
                break; 
            case 2:
                if((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))){
                    d = 29;
                }else{
                    d = 28;
            }
        }
        return d;
    }
    public static void printResults(int d, int m, int y, int sd) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String date = String.format("%s %s", months[m-1], y);
        for (int i = 0; i < (20 - date.length())/2; i++){
            System.out.print(" ");
        }
        System.out.println(date);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int daycount = 1;
        int control = 0;
        for (int s = 0; s < 6; s++) {
            String lst[][] = new String[1][7];
            for (int ds = 0; ds < 7; ds++){
                if (control == 0) {
                    control ++;
                    ds = sd - 2;
                } else {
                    if (daycount > d) {break;}
                    lst[0][ds] = Integer.toString(daycount);
                    daycount++;
                }
            }
            for (int a = 0; a < 7; a++){
                if (lst[0][a] == null){
                    lst[0][a] = "";
                }
            } 
            System.out.println(String.format("%2s %2s %2s %2s %2s %2s %2s", lst[0][0], lst[0][1], lst[0][2], lst[0][3], lst[0][4], lst[0][5], lst[0][6]));
        }
    }
}