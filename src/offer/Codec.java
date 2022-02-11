package offer;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // explanation: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/mian-shi-ti-37-xu-lie-hua-er-cha-shu-ceng-xu-bian-/
    // https://www.bilibili.com/video/BV1jy4y1p7jg?from=search&seid=12963601491450374953&spm_id_from=333.337.0.0

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                sb.append(node.val).append(",");
            } else {
                sb.append("null").append(",");
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] dataArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // left node
            if (!dataArray[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(dataArray[i]));
                node.left = leftNode;
                queue.add(leftNode);
            }
            i++;

            // right node
            if (!dataArray[i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(dataArray[i]));
                node.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }

        return root;
    }


    // second time
    public String serialize_1(TreeNode root) {
        if (root == null) {
            return "null";
        }

        // queue for loop node
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
            } else {
                sb.append("null").append(",");
                continue;
            }

            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.substring(0, sb.length() - 1);    // delete last ,
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_1(String data) {
        if (data.equals("null")) {
            return null;
        }

        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String leftNodeStr = dataArr[index];
            if (!"null".equals(leftNodeStr)) {
                node.left = new TreeNode(Integer.parseInt(leftNodeStr));
                queue.add(node.left);   // 注意，把节点加到队列里面去，否则只有根结点被处理
            }
            index++;

            String rightNodeStr = dataArr[index];
            if (!"null".equals(rightNodeStr)) {
                node.right = new TreeNode(Integer.parseInt(rightNodeStr));
                queue.add(node.right);  // 注意，把节点加到队列里面去，否则只有根结点被处理
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        Codec codec = new Codec();
        String serializeNode = codec.serialize(node1);
        System.out.println(serializeNode);

        TreeNode result = codec.deserialize(serializeNode);
        System.out.println();

    }
}
