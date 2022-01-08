package offer;

import java.util.*;

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

    public List<List<Integer>> levelOrder_1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
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
