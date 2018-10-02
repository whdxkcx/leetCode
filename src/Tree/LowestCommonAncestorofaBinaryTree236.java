package Tree;

import Model.TreeNode;

public class LowestCommonAncestorofaBinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode left_sub = lowestCommonAncestor(root.left, p, q);
        TreeNode right_sub = lowestCommonAncestor(root.right, p, q);
        if(left_sub != null && right_sub != null || root.val == p.val || root.val == q.val) return root;
        return left_sub == null ? right_sub : left_sub;
    }
}
