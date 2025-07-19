import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RationalArrayGenerator array = new RationalArrayGenerator();
        Scanner sc = new Scanner(System.in);
        // test
        System.out.print("Please Enter the denominator: ");
        int n = sc.nextInt();
        sc.nextLine();

        try {
            Rational[] test1 = array.generate(n);
            System.out.print("The generated array:\n[");
            for (Rational num : test1) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        } catch (DivisionByZeroException dbze) {
            System.out.println("Error: " + dbze.getMessage());
        }
        sc.close();
    }
}