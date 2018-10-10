package Tree;

import Model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class PathSumIII437 {
    //So the idea is similar as Two sum, using HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum) , and whenever reach a node, we check if prefix sum - target exists in hashmap or not, if it does, we added up the ways of prefix sum - target into res.
    int count=0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer>  prixMap=new HashMap<>();
        prixMap.put(0,1);
        helper(root,0,sum,prixMap);
        return count;
    }

    public void helper(TreeNode root,int curSum,int target,HashMap<Integer,Integer>  prefixmap) {
        if (root == null) return;
        curSum += root.val;
        if (prefixmap.containsKey(curSum - target))
            count += prefixmap.get(curSum - target);


        if (!prefixmap.containsKey(curSum))
            prefixmap.put(curSum, 1);
        else
            prefixmap.put(curSum,prefixmap.get(curSum)+1);

        helper(root.left,curSum,target,prefixmap);
        helper(root.right,curSum,target,prefixmap);
        prefixmap.put(curSum,prefixmap.get(curSum)-1);
    }
}
