package first200;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest {

    // 用栈来模拟中序遍历
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.addLast(root);
                root = root.left;
            }

            root = queue.pollLast();
            if (--k == 0) {
                return root.val;
            }

            root = root.right;
        }
        return -1;
    }
}
