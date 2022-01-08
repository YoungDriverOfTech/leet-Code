package offer;

import java.util.*;

public class PrintNodeAsLayer {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); // store current layer value

            for (int i = queue.size(); i > 0; i--) { // this is how to divide layers
                TreeNode headNode = queue.remove();
                temp.add(headNode.val);

                if (headNode.left != null) {
                    queue.add(headNode.left);
                }
                if (headNode.right != null) {
                    queue.add(headNode.right);
                }
            }
            result.add(temp);
        }

        return result;
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

        System.out.println(new PrintNodeAsLayer().levelOrder(root));
    }
}
