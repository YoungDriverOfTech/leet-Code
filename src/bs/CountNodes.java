package bs;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {

    // 如果是完美二叉树，那么他的节点数量就是一个公比为2的等比数列，随着层数增加，数量是1 2 4 8 16
    // 那么根据题目给出的定义，叶子结点尽量往左子树排，那么当左子树高度与右子树高度一致的时候，说明左子树是完美二叉树，可以树勇等比数列公式来求数量
    // 而右子树呢进行递归
    // 那么当左子树高度与右子树高度不一致的时候，说明右子树是完美的，用公式来求，左子树进行递归
    // https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 求得左右子树的高度
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return getHeight(treeNode.left) + 1;    // 因为最后叶子节点都放在左侧，所以只用左节点来计算高度即可
    }



    public int countNodes_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            result++;
            if (temp.left != null) {
                queue.add(temp.left );
            }
            if (temp.right != null) {
                queue.add(temp.right );
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(4);
        node2.left = node4;

        System.out.println(new CountNodes().countNodes(root));
    }
}
