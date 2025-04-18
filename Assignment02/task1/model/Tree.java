package model;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value){
        this.value = value;
    }

    public int getValue(){ // This looks totally unnecessary
        return value;
    }

    public Tree getLeft(){ // `this.` can not be used in a static method. good to know
        return left; // No need to write this.left cuz there is no variable shadowing being happened
    }

    public Tree getRight(){
        return right;
    }

    public void setLeft(Tree left){
        this.left = left;
    }

    public void setRight(Tree right){
            this.right = right;
    }

    public String str(){
        String in_order = "";

        if (left != null){
            in_order += left.str();
        }

        in_order += value + " ";

        if (right != null){
            in_order += right.str();
        }

        return in_order;
    }

    public static void main(String[] args){
        Tree node1 = new Tree(5);
        Tree node2 = new Tree(3);
        Tree node3 = new Tree(8);
        Tree node4 = new Tree(1);
        Tree node5 = new Tree(4);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        /* Tree in question:
            5
           / \
          3   8
         / \
        1   4
        */

        System.out.println(node1.str()); // Expected: 1 3 4 5 8
    }
}