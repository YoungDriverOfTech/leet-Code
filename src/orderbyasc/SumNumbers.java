package orderbyasc;

import dfs.TreeNode;

public class SumNumbers {
    private int result = 0;
    private int temp = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        temp = temp * 10 + node.val;

        if (node.left == null && node.right == null) {
            result += temp;
        }

        dfs(node.left);
        dfs(node.right);

        temp = temp / 10;
    }
}
