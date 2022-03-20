package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null").append(",");
            }
        }

        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null".equals(data)) {
            return null;
        }

        int i = 1;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // left node
            if (!"null".equals(arr[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                node.left = left;
                queue.add(left);
            }
            i++;

            // right node
            if (!"null".equals(arr[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }
}
