package Tree;

import Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 判断是否为完全二叉树 {
    //按照层序遍历二叉树，找到第一个只有非满结点（这个节点只有两种情况，孩子为空或者只有左没有右），如果之后的节点还有非满结点，则不是。
   public  boolean IsCompleteTree(TreeNode root)
    {
        if(root == null)
            return false;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.offer(root);
        //这里给一个flag是标记是否出现过满结点
        boolean flag = false;

        while(!q.isEmpty())
        {
            TreeNode pCur= q.pop();
            //如果已经出现过满结点，则后面再出现有孩子的结点则一定不是完全二叉树。
            if(flag)
            {
                if(pCur.left != null || pCur .right != null)
                    return false;
            }
            else{
                if(pCur .left!= null && pCur .right != null)
                {
                    q.push(pCur .left);
                    q.push(pCur .right);
                }
                else if(pCur .left == null && pCur .right != null)
                    return false;
                else if(pCur.left!= null && pCur. right == null)
                {
                    q.push(pCur.left);
                    flag = true;
                }
                else
                    flag = true;
            }
        }
        return true;
    }
}
