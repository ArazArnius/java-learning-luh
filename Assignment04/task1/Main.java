package task1;
import task1.gates.*;
import java.util.Scanner;

public class Main {
    public static int boolToInt(boolean a) {
        return (a ? 1 : 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter the first boolean value: (true/false) ");
        boolean a = sc.nextBoolean();

        System.out.printf("Enter the second boolean value: (true/false) ");
        boolean b = sc.nextBoolean();

        HalfAdder half_adder = new HalfAdder();
        boolean[] result = half_adder.add(a, b);

        System.out.printf("\nThe sum is %d, the carry is %d.\n", boolToInt(result[0]), boolToInt(result[1]));
        
        System.out.printf("\nHalf adder info:\n");
        half_adder.info();

        sc.close();
    }
}