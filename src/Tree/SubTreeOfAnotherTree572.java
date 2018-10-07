package Tree;

import Model.TreeNode;

public class SubTreeOfAnotherTree572 {
  //子树必须是从叶结点开始的，中间某个部分的不能算是子树，那么我们转换一下思路，是不是从s的某个结点开始，跟t的所有结构都一样，那么问题就转换成了判断两棵树是否相同
  public boolean isSubtree(TreeNode s, TreeNode t) {
      if (s==null) return false;
      if (isSame(s, t)) return true;
      return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public  boolean isSame(TreeNode s, TreeNode t) {
        if (s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
