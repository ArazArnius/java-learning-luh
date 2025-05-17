import java.util.Scanner;

public class StringShift {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Please enter the text you want shifted: ");
        StringBuilder text = new StringBuilder(sc.nextLine());
        StringBuilder shifted = new StringBuilder(text.length()); // empty string

        System.out.printf("By how many items would you like to shift the text? ");
        int shift = sc.nextInt();
        sc.nextLine();
        System.out.println("text's length: " + text.length()); // debug


        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            System.out.println(ch);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(((ch - 'a' + shift) % (26)) + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(((ch - 'A' + shift) % (26)) + 'A');
            }
            System.out.println("we reach here!");
            shifted.append(ch);
        }

        System.out.println(text + " shifted by " + shift + " values is: " + shifted);
        sc.close();
    }
}