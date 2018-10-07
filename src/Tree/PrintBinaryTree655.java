package Tree;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = get_height(root), width =(int)Math.pow(height, 2) - 1;
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<height;i++){
            ArrayList<String>  temp=new ArrayList<>();
            for(int j=0;j<width;j++){
                temp.add("");
            }
            res.add(temp);
        }
        helper(res, root, 0, 0, width);
        return res;
    }

    int get_height(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = get_height(root.left), right = get_height(root.right);
        return Math.max(left, right) + 1;
    }

    void helper(List<List<String>> ans, TreeNode root, int level, int l, int r) {
        if (root != null) {
            int mid = l + (r - l) / 2;
            ans.get(level).set( mid,String.valueOf(root.val));
            helper(ans, root.left, level + 1, l, mid - 1);
            helper(ans, root.right, level + 1, mid + 1, r);
        }
    }


}
