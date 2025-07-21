package Box;
import java.util.*;

public class Box implements Comparable<Box> {
    private String content;
    public int weight;

    public Box(String content, int weight) {
        this.content = content;
        this.weight = weight;
    }

    @Override
    public int compareTo(Box other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Box mit Content " +  content + " wiegt " + weight + " kg.";
    }

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Box> boxes = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            boxes.add(new Box("type " + i, random.nextInt(20)));
        }

        System.out.println("Unsortierte Liste:");
        for (Box box : boxes) {
            System.out.println(box);
        }

        Collections.sort(boxes);

        System.out.println("\nSortierte Liste:");
        for (Box box : boxes) {
            System.out.println(box);
        }
    }
}