package offer;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    // my solution, place every layer into a list and return list count
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result++;
        }

        return result;
    }

    // better solution
    // recursion: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(recursion(root.left), recursion(root.right)) + 1;
    }

}
