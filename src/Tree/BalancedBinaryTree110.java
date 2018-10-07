package Tree;

import Model.TreeNode;

public class BalancedBinaryTree110 {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
         height(root);
         return flag;
    }

    public int height(TreeNode root){
        if(root==null) return 0;
        int  leftHeight=height(root.left);
        int  rightHeight=height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)  flag=false;
        return leftHeight>rightHeight?leftHeight:rightHeight;
    }
}
