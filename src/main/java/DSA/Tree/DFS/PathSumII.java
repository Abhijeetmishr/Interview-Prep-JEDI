package DSA.Tree.DFS;
import java.util.*;

public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> sol, List<List<Integer>> res){
        if(root == null){
            return;
        }

        sol.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(sol));
        } else {
            pathSum(root.left, sum - root.val, sol, res);
            pathSum(root.right, sum - root.val, sol, res);
        }
        sol.remove(sol.size()-1);
    }
}
