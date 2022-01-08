package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeAsToggleOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // ps: addFirst/addLast is Linked's method, so define reference with linkedList
            LinkedList<Integer> temp = new LinkedList<>(); // Linked implements Deque which can insert element in head and tail

            for (int i = queue.size(); i > 0; i--) {
                TreeNode headNode = queue.remove();
                if (result.size() % 2 == 0) { // head layer
                    temp.addLast(headNode.val);
                } else {
                    temp.addFirst(headNode.val); // tail layer
                }

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

        System.out.println(new PrintTreeAsToggleOrder().levelOrder(root));
    }


}
