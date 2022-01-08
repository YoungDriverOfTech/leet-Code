package offer;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PrintTree {
    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            resultList.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode sonNodeLeft = new TreeNode(9);
        TreeNode sonNodeRight = new TreeNode(20);
        root.left = sonNodeLeft;
        root.right = sonNodeRight;
        TreeNode grandSonNodeLeft = new TreeNode(15);
        TreeNode grandSonNodeRight = new TreeNode(7);
        sonNodeRight.left = grandSonNodeLeft;
        sonNodeRight.right = grandSonNodeRight;

        System.out.println(Arrays.toString(new PrintTree().levelOrder(root)));
    }
}
