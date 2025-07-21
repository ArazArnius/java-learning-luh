package TextAnalyze;
import java.util.*;

public class TextAnalyze {
    public static void main(String[] args) {
        String text = "Dieser Text dient als Beispieleingabe für die obige Aufgabe";
        String[] words = text.split(" +");
        // ArrayList<String> wordsList = new ArrayList<>();
        ArrayList<Integer> lenList = new ArrayList<>();

        for (String word : words) {
            // wordsList.add(word);
            int len = word.length();
            if (!lenList.contains(len)) {
                lenList.add(len);
            }
        } // not needed

        System.out.println("unsorted:\n" + text);
        // for (String word : wordsList) {
        //     System.out.print(word + " ");
        // } // not needed

        // System.out.println("lenghts:");
        // for (int l : lenList) {
        //     System.out.print(l + " ");
        // } // works

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
    }
}