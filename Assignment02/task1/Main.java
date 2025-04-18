import model.*;

public class Main {
    public static void main (String[] args){
        // Test case 1:
        Tree nodea1 = new Tree(5);
        Tree nodea2 = new Tree(3);
        Tree nodea3 = new Tree(8);
        Tree nodea4 = new Tree(1);
        Tree nodea5 = new Tree(4);

        nodea1.setLeft(nodea2);
        nodea1.setRight(nodea3);

        nodea2.setLeft(nodea4);
        nodea2.setRight(nodea5);

        /* Tree in question:
            5
           / \
          3   8
         / \
        1   4
        */

        System.out.println(nodea1.str()); // Expected: 1 3 4 5 8

        // Test case 2
        Tree nodeb1 = new Tree(5);
        Tree nodeb2 = new Tree(3);
        Tree nodeb3 = new Tree(8);
        Tree nodeb4 = new Tree(7);
        Tree nodeb5 = new Tree(12);

        nodeb1.setLeft(nodeb2);
        nodeb1.setRight(nodeb3);

        nodeb3.setLeft(nodeb4);
        nodeb3.setRight(nodeb5);

        /* Tree in question:
            5
           / \
          3   8
             / \
            7   12
        */

        System.out.println(nodeb1.str()); // Expected: 3 5 7 8 12
    }
}