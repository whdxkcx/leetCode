package Tree;

import Model.TreeNode;

public class DiameterofBinaryTree543 {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans-1;
    }
    public int  height(TreeNode root){
        if(root==null)  return 0;
        int leftHeingt=height(root.left);
        int rightHeight=height(root.right);
        ans=Math.max(ans,leftHeingt+rightHeight+1);
        return (leftHeingt>rightHeight?leftHeingt:rightHeight)+1;
    }

}
