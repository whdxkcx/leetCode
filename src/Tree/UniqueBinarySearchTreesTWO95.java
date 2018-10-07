package Tree;

import Model.TreeNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesTWO95 {
    public static void main(String[] args){
      System.out.println(generateTrees(0));
    }
    public static  List<TreeNode> generateTrees(int n) {
        if(n==0)  return new ArrayList<>();
        List<TreeNode> res=GenerateSubTree(1,n+1);
        return res;
    }

  static  List<TreeNode> GenerateSubTree(int l, int r) {
        List<TreeNode> subTree=new ArrayList<>();

        if (l >= r) {
            subTree.add(null);
            return subTree;
        }

        if (l == r - 1) {
            subTree.add(new TreeNode(l));
            return subTree;
        }


        for (int i = l; i < r; ++i) {
            List<TreeNode> leftSubTree = GenerateSubTree(l, i);
            List<TreeNode> rightSubTree = GenerateSubTree(i + 1, r);
            for (int m = 0; m < leftSubTree.size(); ++m) {
                for (int n = 0; n < rightSubTree.size(); ++n) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree.get(m);
                    root.right = rightSubTree.get(n);
                    subTree.add(root);
                }
            }
        }

        return subTree;
    }
}
