package tree;

import java.util.*;

public class RightSideView {

    // BFS
    // 时间复杂度： O(N)，每个节点都入队出队了 1 次。
    // 空间复杂度： O(N)，使用了额外的队列空间。
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        // 层序遍历，把每一层取出来，装进一个list，然后把每一层list的最后一个元素拿出来，让进list即可
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<LinkedList<TreeNode>> resultList = new ArrayList<>();

        while (!queue.isEmpty()) {
            LinkedList<TreeNode> list = new LinkedList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                list.addFirst(node);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resultList.add(list);
        }

        List<Integer> result = new ArrayList<>();
        for (LinkedList<TreeNode> link : resultList) {
            result.add(link.removeFirst().val);
        }
        return result;
    }

    // 时间复杂度： O(N)
    // 空间复杂度： O(N)
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView_1(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 这个depth是一个局部变量，在添加右子树的时候会一直加，等到返回左子树的时候，又会恢复原来的值，所以不一定会和list的size相等，左子树的值也就不会被加入res
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
