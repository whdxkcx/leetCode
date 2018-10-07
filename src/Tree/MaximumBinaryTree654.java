package Tree;

import Model.TreeNode;

import java.util.Stack;

public class MaximumBinaryTree654 {
    //用栈，
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode>  st=new Stack<>();
        for(int num:nums){
            TreeNode cur=new TreeNode(num);
            while(!st.isEmpty()&&st.peek().val<num){
                cur.left=st.pop();
            }
            if(!st.isEmpty()) st.peek().right=cur;
            st.push(cur);
        }
        TreeNode root=null;
        while(!st.isEmpty()){
            root=st.pop();
        }
        return root;
    }
}
