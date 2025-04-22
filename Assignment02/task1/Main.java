import model.*;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("Tree A:\n" + node_a1.str()); // Expected: 1 3 4 5 8
        System.out.println("Tree B has a node with value of 6? " + (node_a1.contains(6) ? "Yes." : "No.")); // Expected no
        System.out.println("Tree B has a node with value of 1? " + (node_a1.contains(1) ? "Yes." : "No.")); // Expected yes
        System.out.println("Tree B has a node with value of 5? " + (node_a1.contains(5) ? "Yes." : "No.")); // Expected yes
        node_a1.insertValue(1);
        System.out.println("1 added: " + node_a1.str()); // Expected: 1 3 4 5 8
        node_a1.insertValue(2);
        System.out.println("2 added: " + node_a1.str()); // Expected: 1 2 3 4 5 8
        node_a1.insertValue(6);
        System.out.println("6 added: " + node_a1.str()); // Expected: 1 2 3 4 5 6 8
        node_a1.insertValue(7);
        System.out.println("7 added: " + node_a1.str()); // Expected: 1 2 3 4 5 6 7 8
        System.out.println();

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
        System.out.println("Tree B:\n" + node_b1.str()); // Expected: 3 5 7 8 12
        System.out.println("***\nTo verify findNode(value - 1 || value + 1) works (successor of value)\n" +
                            "findNode(7-1): \nValue: " + node_b1.findNode(7 - 1).getValue() + "\nfindNode(7+1):" + 
                            "\nValue: " + node_b1.findNode(7 + 1).getValue() + "\n***");
        System.out.println("Tree B has a node with value of 6? " + (node_b1.contains(6) ? "Yes." : "No.")); // Expected no
        System.out.println("Tree B has a node with value of 12? " + (node_b1.contains(12) ? "Yes." : "No.")); // Expected yes
        System.out.println("Tree B has a node with value of 5? " + (node_b1.contains(5) ? "Yes." : "No.")); // Expected yes

        node_b1.insertValue(3);
        System.out.println("3 added: " + node_b1.str()); // Expected: 3 5 7 8 12
        node_b1.insertValue(4);
        System.out.println("4 added: " + node_b1.str()); // Expected: 3 4 5 7 8 12
        node_b1.insertValue(15);
        System.out.println("15 added: " + node_b1.str()); // Expected: 3 4 5 7 8 12 15

        node_b1.deleteValue(4); // leaf
        System.out.println("\n4 deleted: " + node_b1.str()); // Expected: 3 5 7 8 12 15
        node_b1.deleteValue(3); // 1 child
        System.out.println("3 deleted: " + node_b1.str()); // Expected: 5 7 8 12 15
        node_b1.deleteValue(8); // normal 2 children
        System.out.println("8 deleted: " + node_b1.str()); // Expected: 5 7 12 15
        node_b1.deleteValue(5); // root: code not working for deleting the root since we are calling str on the root!

        System.out.println("5 deleted: str called from node 5: " + node_b1.str()); // Expected: 7 12 15 
        // since in the code we change pointers from and to the successor and the delted node, here 7 can not be shown from node_b1 anymore (my assumption)
        System.out.println("5 deleted: str called from node 7: " + node_b4.str()); // and my assumption is correct
    }
}