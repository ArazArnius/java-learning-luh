package debug;

import debug.model.*;


public class Debug {
  public static void main(String[] args) {
    
    IntBinTreeNode treeSorted = new SortedIntBinTreeNode(1, null, null);
    IntBinTreeNode treeUnsorted = new UnsortedIntBinTreeNode(1, null, null);
    int[] toInsert = { 4, 2, 6, 8, 0, 2, 1, 5, 1 };
    // for each i in toInsert
    for (int i : toInsert) {
      treeSorted.insert(i);
      treeUnsorted.insert(i);
    }
    System.out.println(treeSorted);
    System.out.println(treeUnsorted);
  }
}

/*
SortedIntBinTreeNode.java:5: error: SortedIntBinTreeNode is not abstract and does not override abstract method contains(int) in IntBinTreeNode
public class SortedIntBinTreeNode extends IntBinTreeNode {
       ^
*/