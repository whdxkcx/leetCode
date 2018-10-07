package Model;

public class TreeNode {
    public int val;
    public boolean isFirst=true;//用于后序非递归遍历时判断是否位第一次位于栈顶
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}
