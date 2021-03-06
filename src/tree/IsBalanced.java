package tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 必须保证左右节点的高度差不超过1，并且左右节点也得保持平衡
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
