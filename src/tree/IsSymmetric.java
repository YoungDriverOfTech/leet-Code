package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    // 递归
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

    // 迭代
    public boolean isSymmetric_1(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
