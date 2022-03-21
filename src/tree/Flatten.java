package tree;

public class Flatten {

    // 后序遍历
    // https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/comments/
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}
