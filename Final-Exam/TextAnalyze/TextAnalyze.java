package TextAnalyze;
import java.util.*;

public class TextAnalyze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mode = "y";
        while (mode.equals("y")) {
            System.out.print("Please enter your text:\t");
            String text = sc.nextLine();
            String[] words = text.split(" +");
            ArrayList<Integer> lenList = new ArrayList<>();

            for (String word : words) {
                int len = word.length();
                if (!lenList.contains(len)) {
                    lenList.add(len);
                }
            } 

            System.out.println("Entered text:\n" + text);

            Collections.sort(lenList);

            for (int l : lenList) {
                System.out.print(l + ": ");
                for (String word : words) {
                    if (word.length() == l) {
                        System.out.print(word + " ");
                    }
                }
                System.out.println();
            }

            System.out.print("Do you want to continue? (y/n)\t");
            mode = sc.nextLine();
        }
        System.out.println("Bye bye");
    }
}