package tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverTree {
    public void recoverTree(TreeNode root) {
        // 使用中序遍历，把节点依次放入list中，然后遍历list，因为是中序遍历，本来是有序的，因为互换了位置，所以无序
        // 例如 1 2 3 7 5 6 4，呼唤了位置导致了，出现了两对不满足升序的数字7 5，6 4，那么我们找到第一对的首数字
        // 和第二对的位数字，给他们交换一下值就可以了

        // 还有一种特殊的case 1324， 这样的话只有一对逆序对，那么只要把这一对逆序到反转一下就可以了
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);

        TreeNode node1 = null;
        TreeNode node2 = null;
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode pre = list.get(i);
            TreeNode after = list.get(i + 1);

            // 找到了逆序对
            if (pre.val > after.val) {
                // 第二对逆序对的尾元素
                node2 = after;

                // 首对逆序对的首元素
                if (node1 == null) {
                    node1 = pre;
                } else {
                    break;
                }
            }
        }

        // 互换两个节点的值就可以了
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

}
