package Tree;

import Model.TreeNode;

public class BinaryTreeTilt563 {
    int res=0;
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
        sumOfTree(root);
        return res;
    }

    public int sumOfTree(TreeNode root) {
        if(root==null) return 0;
        int leftSum=sumOfTree(root.left);
        int rightSum=sumOfTree(root.right);
        res= res+Math.abs(leftSum-rightSum);
        return rightSum+leftSum+root.val;
    }
}
