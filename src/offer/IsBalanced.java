package offer;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // ps: all nodes have to keep balance, which means we should judge every node's balance instead root node only
        return Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int getTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getTreeDepth(node.left), getTreeDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(2);
        root.left = leftNode;
        root.right = rightNode;

        TreeNode leftNode_3 = new TreeNode(3);
        TreeNode rightNode_3 = new TreeNode(3);
        leftNode.left = leftNode_3;
        rightNode.right = rightNode_3;

        TreeNode leftNode_4 = new TreeNode(4);
        TreeNode rightNode_4 = new TreeNode(4);
        leftNode_3.left = leftNode_4;
        rightNode_3.right = rightNode_4;

        System.out.println(new IsBalanced().isBalanced(root));
    }
}
