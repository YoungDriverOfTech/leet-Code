package hot100;

import dfs.TreeNode;

public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
