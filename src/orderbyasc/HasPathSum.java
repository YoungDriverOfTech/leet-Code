package orderbyasc;

import dfs.TreeNode;

public class HasPathSum {
    private int targetSum;
    private boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        this.targetSum = targetSum;
        pathExists(root);
        return res;
    }

    private void pathExists(TreeNode node) {
        // preOrder
        if (node == null) {
            return;
        }

        targetSum -= node.val;
        if (targetSum == 0 && node.left == null && node.right == null) {
            res = true;
            return;
        }

        pathExists(node.left);
        pathExists(node.right);

        targetSum += node.val;
    }
}
