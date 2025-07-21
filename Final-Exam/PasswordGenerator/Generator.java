package PasswordGenerator;
import java.util.Scanner;

public class Generator {
    private String text;
    private String password;

    public Generator(String text) {
        this.text = text;
        password = "";
        String[] parts = text.split(" +");
        for (String word : parts) {
            password += word.charAt(0);
        }

        int upperCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (isUpper(text.charAt(i))) {
                upperCount++;
            }
        }
        password += upperCount;
    }

    public boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    @Override
    public String toString() {
        return password;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to password generator.");
        String c;
        do {
            System.out.println("Please enter your text: ");
            String text = sc.nextLine();
            Generator g1 = new Generator(text);
            System.out.println(text + " -> " + g1);
            
            System.out.print("Continue? (y/n)\t");
            c = sc.nextLine();
        } while (c.equals("y"));
    }
}