import Model.TreeNode;

public class SymmetricTree101 {
//    判断一颗二叉树是不是对称的，等价于判断其左右子树是不是镜像对称的
//    判断镜像对称即判断对称的位置上的元素是不是相等
//    两个节点A和B对称等价于:
//    这两个节点上存储的值相等
//    节点A的左子树节点和节点B的右子树上的节点是对称的
//    节点A的右子树节点和节点A的左子树上的节点是对称的
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode p1,TreeNode p2) {
        if(p1==null&&p2==null) return true;
        if(p1==null||p2==null)  return false;
        return p1.val==p2.val&&isSymmetric(p1.left,p2.right)&&isSymmetric(p1.right,p1.left);
    }
}
