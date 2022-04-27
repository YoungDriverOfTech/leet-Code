package orderbyasc;

import dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    private List<List<Integer>> res = new ArrayList<>();
    private Integer targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        getPaths(root, new ArrayList<Integer>());
        return res;
    }

    private void getPaths(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        targetSum -= node.val;
        list.add(node.val);
        if (targetSum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }

        getPaths(node.left, list);
        getPaths(node.right, list);

        targetSum += node.val;
        list.remove(list.size() - 1);
    }
}
