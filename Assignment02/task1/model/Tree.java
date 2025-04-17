public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    Tree(int value){
        this.value = value;
    }

    public int getValue(){ // This looks totally unnecessary
        return this.value;
    }

    public Tree getLeft(){ // `this.` can not be used in a static method. good to know
        return this.left;
    }

    public Tree getRight(){
        return this.right;
    }

    public void setLeft(Tree left){
        this.left = left;
    }

    public void setRight(Tree right){
            this.right = right;
    }
}