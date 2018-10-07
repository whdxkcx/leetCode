package Tree;

import Model.TreeNode;

import java.util.LinkedList;

public class PostOrderTraversalTree {
    //后序遍历的非递归实现比前序、中序的非递归实现 要复杂一点。需要一个标识来标记某结点是否第一次位于栈顶（该结点的左子树已经遍历完毕，从左子树返回准备遍历它的右子树）
    //
    //对于后序遍历而言，结点的左右子树都遍历完成之后，才访问该结点。某结点会两次位于栈顶，第一次是该结点的左子树都遍历完了，然后 获取 栈顶结点，切换到该结点的右孩子，准备遍历它的右子树，当该结点的右子树也都遍历完后，它就会第二次位于栈顶，此时将栈顶元素出栈。
    private void postNonRecurTraverse(TreeNode root){
                LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
                  TreeNode currentNode, tmp;
                 currentNode = root;
                 while(currentNode != null || !stack.isEmpty())
                     {
                         while(currentNode != null)
                             {
                                 stack.push(currentNode);
                                currentNode = currentNode.left;
                             }
                         if(!stack.isEmpty())
                             {
                                 tmp = stack.getFirst();
                               //从左子树返回,需要判断它的右子树是否已经访问了
                                if(tmp.isFirst)//右子树还未被访问
                                     {
                                         tmp.isFirst = false;
                                        currentNode = tmp.right;
                                     }
                                 else{//左右子树都已经访问了
                                        tmp = stack.pop();
                                         System.out.print(tmp.val + " ");//visit
                                     }
                             }
                     }
    }
}
