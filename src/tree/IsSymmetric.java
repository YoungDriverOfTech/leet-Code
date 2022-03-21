package tree;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return isSymmetric(left, right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 == null) {
            return false;
        }
        if (node1 == null && node2 != null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetric(node1.left, node2.right) &&
                isSymmetric(node1.right, node2.left);
    }
}