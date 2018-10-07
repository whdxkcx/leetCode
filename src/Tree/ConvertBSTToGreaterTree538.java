package Tree;

import Model.TreeNode;

public class ConvertBSTToGreaterTree538 {
    // 先将右子树转换为累加树；并记录右子树的累加和rightSum;
    // 然后处理根节点，根节点的值 = 根节点值 + rightSum;
    // 然后转化左子树
    public TreeNode convertBST(TreeNode root) {
        convert(root,0);
        return root;
    }
    public int  convert(TreeNode root, int rightSum){
         if(root==null)  return rightSum;
         rightSum=convert(root.right,rightSum);
         root.val+=rightSum;
         rightSum=root.val;
         rightSum=convert(root.left,rightSum);
         return  rightSum;
    }
}
