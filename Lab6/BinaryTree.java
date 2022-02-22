
public class BinaryTree {

   /**
   * Reference to the root Node of the tree
   */
   BinaryTreeNode root = null;

   /**
   * Insert the data into the tree
   * @param newData New int to store in the tree
   */
   public void insertInTree (int newData) {
       if (root == null)
           root = new BinaryTreeNode(newData);
       else
           root.insert(newData);
   }

   /**
   * Method to display the contents of the tree
   */
   public void displayInOrder () {
       displayInOrder (root);
   }
  
   /**
   * Traverse the tree using InOrder traversal and display the content to the console
   * @param subRoot The node to start with
   */
   private void displayInOrder (BinaryTreeNode subRoot){
       if (subRoot == null)   
           return;
       displayInOrder (subRoot.getLeft());
       System.out.print(" " + subRoot.getData() + " ");
       displayInOrder (subRoot.getRight());
   }
   
   /**
   * Method the get the height of the tree
   */
   public int getTreeHeight () {
       int height = getTreeHeight (root);
       return height;
   }
   
   /**
   * Get the height of the tree - Recursive Method
   * @param subRoot The node to start with
   */
   private int getTreeHeight (BinaryTreeNode subRoot){
       // When height of the tree is zero
       if(subRoot == null){
           return 0;
       }
       
       return (1 + Math.max( getTreeHeight(subRoot.getLeft()), getTreeHeight(subRoot.getRight())) );
   }
   
}
