package dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;    // 第一层

            // 从第二层开始
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    // 层序遍历，把每一层取出来，然后设定对应的next指针就可以了
    public Node connect_1(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {  // 别忘记加上否定的符号
            Stack<Node> stack = new Stack<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                Node node = queue.poll();
                stack.push(node);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            Node rightNode = null;
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (rightNode == null) {
                    node.next = null;
                } else {
                    node.next = rightNode;
                }
                rightNode = node;
            }
        }

        return root;
    }
}
