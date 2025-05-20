package debug.model;

//Inserts integers in a sorted way. Only needs to search in one subtree as a
//result.
public class SortedIntBinTreeNode extends IntBinTreeNode {
  
  public SortedIntBinTreeNode(int content, IntBinTreeNode left, IntBinTreeNode right) {
    super(content, left, right);
    if ((left != null && left.content_ >= content) || (right != null && right.content_ <= content)) {
      System.err.println("Trying to create invalid sorted tree.");
      System.exit(2);
    }
  }

  /**
   * Inserts integer into the sorted tree.
   * Smaller Integers will be placed into the left subtree, larger ones into
   * the right subtree. Equal ones will be ignored
   * 
   * @param i Integer to insert.
   */
  @Override
  public void insert(int i) {
    if (i < super.content_) {
      if (super.left_ == null) 
        super.left_ = new SortedIntBinTreeNode(i, null, null);
      else
        super.left_.insert(i);
    } else if (i > super.content_) {
      if (super.right_ == null) 
        super.right_ = new SortedIntBinTreeNode(i, null, null);
      else
        super.right_.insert(i);
    }
  }

  @Override
  public boolean contains(int i) {
    if (super.content_ == i) {
      return true;
    } else if (super.left_ != null && i < super.content_) {
      return super.left_.contains(i);
    } else if (super.right_ != null && i > super.content_) {
      return super.right_.contains(i);
    }
    return false;
  }

  public static void main(String[] args) {
    IntBinTreeNode treeSorted = new SortedIntBinTreeNode(1, null, null);
    int[] toInsert = { 4, 2, 6, 8, 0, 2, 1, 5, 1 };
    // for each i in toInsert
    for (int i : toInsert) {
      treeSorted.insert(i);
    }
    System.out.println(treeSorted);
  }
}