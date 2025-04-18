import model.*;

public class Main {
    public static void main (String[] args){
        // Test case 1:
        Tree node_a1 = new Tree(5);
        Tree node_a2 = new Tree(3);
        Tree node_a3 = new Tree(8);
        Tree node_a4 = new Tree(1);
        Tree node_a5 = new Tree(4);

        node_a1.setLeft(node_a2);
        node_a1.setRight(node_a3);

        node_a2.setLeft(node_a4);
        node_a2.setRight(node_a5);

        /* Tree in question:
            5
           / \
          3   8
         / \
        1   4
        */

        System.out.println(node_a1.str()); // Expected: 1 3 4 5 8

        // Test case 2
        Tree node_b1 = new Tree(5);
        Tree node_b2 = new Tree(3);
        Tree node_b3 = new Tree(8);
        Tree node_b4 = new Tree(7);
        Tree node_b5 = new Tree(12);

        node_b1.setLeft(node_b2);
        node_b1.setRight(node_b3);

        node_b3.setLeft(node_b4);
        node_b3.setRight(node_b5);

        /* Tree in question:
            5
           / \
          3   8
             / \
            7   12
        */

        System.out.println(node_b1.str()); // Expected: 3 5 7 8 12
    }
}