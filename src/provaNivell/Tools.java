package provaNivell;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {

    public static String getString(String missatge){
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean correct = false;

        do {
            System.out.println(missatge);
            try {
                input = sc.nextLine();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input. Insert caracters.");
            }
            //sc.nextLine();
        } while(!correct);
        return input;
    }

    public static int getInt(String missatge){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean correct = false;

        do {
            System.out.println(missatge);
            try {
                input = sc.nextInt();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input. Insert integers.");
            }
            sc.nextLine();
        } while(!correct);
        return input;
    }

    public static double getDouble(String missatge){
        Scanner sc = new Scanner(System.in);
        double input = 0;
        boolean correct = false;

        do {
            System.out.println(missatge);
            try {
                input = sc.nextDouble();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input. Insert double.");
            }
            sc.nextLine();
        } while(!correct);
        return input;
    }

}
