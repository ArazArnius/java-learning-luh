package model;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public int getValue() { // This looks totally unnecessary
        return value;
    }

    public Tree getLeft() { // `this.` can not be used in a static method. good to know
        return left; // No need to write this.left cuz there is no variable shadowing being happened
    }

    public Tree getRight() {
        return right;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
            this.right = right;
    }

    // returns a string containing a tree in-order traverse 
    public String str() {
        String in_order = "";

        if (left != null) {
            in_order += left.str();
        }

        in_order += value + " ";

        if (right != null) {
            in_order += right.str();
        }

        return in_order;
    }

    // checks whether a value is in the tree and uses binary tree features and is O(log n)
    public boolean contains(int value) {
        if (this.value == value) { // no need to define bool con = 0
            return true;
        }

        if (left != null && this.value > value) {
            return left.contains(value);
        }

        if (right != null && this.value < value) {
            return right.contains(value);
        }

        return false;
    }

    /*
    // checks whether the node `value` is in the tree
    // but is O(n) since it doesn't really use the binary tree features
    public boolean contains(int value) {
        boolean con = false;

        if (left != null && con == false) {
            con = left.contains(value);
        }

        if (this.value == value) {
            return true;
        }

        if (right != null && con == false) {
            con = right.contains(value);
        }

        return con;
    }
    */

    // returns the node if it exists, otherwise the parent of where it had been shown.
    public Tree findNode(int value) {
        if (this.value > value) {
            if (left == null) {
                return this; // return the node, to which value is gonna bind
            }
            return left.findNode(value);
        } else if (this.value < value) {
            if (right == null) {
                return this;
            }
            return right.findNode(value);
        } else {
            return this;
        }
    }

    // returns the given node's (value's) parent
    public Tree findParent(int value) {
        if ((left != null && left.getValue() == value) || 
            (right != null && right.getValue() == value)) {
            return this;
        }
        
        if (value < this.value && left != null) {
            return left.findParent(value);
        }
        
        if (value > this.value && right != null) {
            return right.findParent(value);
        }

        return null; // value not in the tree or root
    }

    public void insertValue(int value) {
        if (this.contains(value)) {
            System.out.println("Error at insertion: A node with value of " + value + " already exists in the tree! ");
            return;
        }

        Tree parent = this.findNode(value); // save a pointer to the parent so we don't call the method multiple times

        if (parent.value > value) { // define whether new node is inserted at the right or the left side
            parent.setLeft(new Tree(value));
        } else {
            parent.setRight(new Tree(value));
        }
    }

    // honestly I don't know how to implement deletion 
    // and this is probably the worst implementatin in programming's history
    public void deleteValue(int value) {
        if (!this.contains(value)) {
            System.out.println("Error at deletion: There is no node with value of " + value + " in the tree! ");
            return;
        }

        Tree parent = this.findParent(value);
        Tree node = this.findNode(value);

        // case 1: node that is being deleted is a leaf
        if (parent != null && node.getRight() == null && node.getLeft() == null) {
            if (parent.getRight() == node) { // to figure whether node is right or left child of parent
                parent.setRight(null); // node is deleted
            } else {
                parent.setLeft(null);
            }
        } // case 2: node has one child
        else if (parent != null && (node.getRight() == null ^ node.getLeft() == null)) { // node has either right or left child
            if (parent.getRight() == node) {
                parent.setRight(node.getRight() == null ? node.getLeft() : node.getRight()); // set parent't edge to node's child
            } else if (parent.getLeft() == node) {
                parent.setLeft(node.getRight() == null ? node.getLeft() : node.getRight());
            }
            return;
        } // case 3: node has 2 children
        else {
            Tree successor = this.findNode(value - 1); // find the previous or after value of in in-order (works only since values are int)
            if (successor.value == value) {
                successor = this.findNode(value + 1);
            }
            System.out.println("successor: " + successor.getValue());
            Tree s_parent = this.findParent(successor.getValue());
            
            if (parent == null) { // case 4: node is root of the tree
                parent = node;
            } else if (parent.getRight() == node) {
                parent.setRight(successor); // set parent's corresponding edge to point to successor
            } else if (parent.getLeft() == node) {
                parent.setLeft(successor);
            }

            // remove pointers to the successor by its parent (technically deleting it like a node but since we have no setValue we need to change pointers for it to work)
            if (s_parent.getRight() == successor) { // to figure whether node is right or left child of parent
                s_parent.setRight(null);
                // the successor can have max one child (if left smaller inorder, then left child) and vise versa
                if (successor.getRight() != null) { 
                    s_parent.setRight(successor.getRight());
                } else if (successor.getLeft() != null) {
                    s_parent.setRight(successor.getLeft());
                }
            } else {
                s_parent.setLeft(null);
                if (successor.getRight() != null) { 
                    s_parent.setLeft(successor.getRight());
                } else if (successor.getLeft() != null) {
                    s_parent.setRight(successor.getLeft());
                }
            }

            successor.setLeft(node.getLeft());
            successor.setRight(node.getRight());
        }
        return;
    }

    public static void main(String[] args) {
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