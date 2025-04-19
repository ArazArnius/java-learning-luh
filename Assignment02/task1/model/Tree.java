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

    // returns a string containing a tree in-order traverse 
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

    // checks whether a value is in the tree and uses binary tree features and is O(log n)
    public boolean contains (int value){
        if (this.value == value){ // no need to define bool con = 0
            return true;
        }

        if (left != null && this.value > value){
            return left.contains(value);
        }

        if (right != null && this.value < value){
            return right.contains(value);
        }

        return false;
    }

    /*
    // checks whether the node `value` is in the tree
    // but is O(n) since it doesn't really use the binary tree features
    public boolean contains (int value){
        boolean con = false;

        if (left != null && con == false){
            con = left.contains(value);
        }

        if (this.value == value){
            return true;
        }

        if (right != null && con == false){
            con = right.contains(value);
        }

        return con;
    }
    */

    public Tree findPos(int value){
        if (this.value == value){ // to be used in delete
            return this; 
        }

        if (this.value > value){
            if (left == null){
                return this; // return the node to which value is gonna bind
            }
            return left.findPos(value);
        }

        if (this.value < value){
            if (right == null){
                return this;
            }
            return right.findPos(value);
        }

        return this;
    }

    public void insertValue(int value){
        if (this.contains(value)){
            System.out.println("Error at insertion: A node with value of " + value + " already exists in the tree! ");
            return;
        }

        Tree parent = this.findPos(value); // save a pointer to the parent so we don't call the method multiple times

        if (parent.value > value) { // define whether new node is inserted at the right or the left side
            parent.setLeft(new Tree(value));
        } else {
            parent.setRight(new Tree(value));
        }
    }

    // honestly I don't know how to implement deletion
    // public void deleteValue(int value){
    //     if (!this.contains(value)){
    //         System.out.println("Error at deletion: There is no node with value of " + value + " in the tree! ");
    //         return;
    //     }

        
    // }

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