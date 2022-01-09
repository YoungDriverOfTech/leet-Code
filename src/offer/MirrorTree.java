package offer;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        reverseTree(root);
        return root;
    }

    private void reverseTree(TreeNode treeNode) {
        if (treeNode != null) {
            TreeNode tempNode = null;
            tempNode = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tempNode;

            reverseTree(treeNode.left);
            reverseTree(treeNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        node2.left = node5;
        node2.right = node6;

        TreeNode node = new MirrorTree().mirrorTree(root);
        System.out.println(node);


    }
}
