package offer;

import java.util.*;
import java.util.stream.Collectors;

public class TreeToDoubleList {

/**
    // 打印中序遍历
    void printMiddle(Node root) {
        if(root == null) return;
        dfs(root.left); // 左
        System.out.println(root.val); // 根
        dfs(root.right); // 右
    }
*/

    TreeNode head = null;
    TreeNode pre = null;


    // better solution
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root);

        // change head and tail node pointer
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode node) {
        // find left-bottom node
        if (node == null) {
            return;
        }

        dfs(node.left);

        if (pre != null) {
            // find left-bottom node's parent node, and change pointer of node here
            pre.right = node;
            node.left = pre;
        } else {
            // save pre pointer
            head = node;
        }

        // change pre node pointer for next dfs
        pre = node;

        // dfs right node
        dfs(node.right);
    }


    // my solution: Ok with local environment, but leetCode is not work. have no idea what is reason
    public TreeNode treeToDoublyList_1(TreeNode root) {
        if (root == null) {
            return null;
        }

        // put all tree elements into a list
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        // change list order as asc
        list = list.stream().sorted(Comparator.comparing(node -> node.val)).collect(Collectors.toList());

        // rearrange node relationship
        for (int i = 1; i < list.size(); i++) {
            TreeNode previousNode = list.get(i - 1);
            TreeNode currentNode = list.get(i);

            previousNode.right = currentNode;
            currentNode.left = previousNode;
        }
        TreeNode firstNode = list.get(0);
        TreeNode lastNode = list.get(list.size() - 1);
        firstNode.left = lastNode;
        lastNode.right = firstNode;

        return firstNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;

        TreeNode leftChild = new TreeNode(1);
        TreeNode rightChild = new TreeNode(3);
        left.left = leftChild;
        left.right = rightChild;

        TreeNode treeNode = new TreeToDoubleList().treeToDoublyList(root);
        System.out.println();
    }
}
