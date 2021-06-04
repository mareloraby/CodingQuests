public class isSubTree {


    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }



    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            // if the subtree we are looking for is also null, then it's essentially a subtree of the root
            return (subRoot == null);
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subTree) {
        if(root == null && subTree == null) {
            return true;
        }
        if(root == null || subTree == null) {
            // one of the two roots is null while the other has value
            return false;
        }
        return (root.val == subTree.val) && isSameTree(root.left, subTree.left) && isSameTree(root.right, subTree.right);
    }

    public static void main(String[] args) {

    }
}
