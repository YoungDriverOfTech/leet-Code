package tree;

import java.util.*;

public class RightSideView {
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
        for (LinkedList<TreeNode> link: resultList) {
            result.add(link.removeFirst().val);
        }
        return result;
    }
}
