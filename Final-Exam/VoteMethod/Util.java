package VoteMethod;
import java.util.*;

public class Util {
    public static <T> T vote(T a, T b, T c) {
        ArrayList<T> votes = new ArrayList<>(List.of(a, b, c));
        T most_freq = votes.get(0);
        int max_occ = 0;

        for (int i = 0; i < votes.size(); i++) {
            int count = 0;
            for (int j = i; j < votes.size(); j++) {
                if (votes.get(i).equals(votes.get(j))) {
                    count++;
                }
            }
            if (count > max_occ) {
                most_freq = votes.get(i);
                max_occ = count;
            }
        }

        return most_freq;

        /* // or
        if (a.equals(b) || a.equals(c)) return a;
        if (b.equals(c)) return b;
        return a;
        */
    }

    public static void main(String[] args) {
        System.out.println("Vote result with [Eimer, Schaufel, Eimer] is -> " + Util.vote("Eimer", "Schaufel", "Eimer"));
        System.out.println("Vote result with [2, 2, 2] is -> " + Util.vote(2, 2, 2));
        System.out.println("Vote result with [a, b, c] is -> " + Util.vote('a', 'b', 'c'));
    }
}