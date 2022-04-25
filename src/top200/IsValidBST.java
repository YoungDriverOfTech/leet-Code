package top200;

public class IsValidBST {


    private TreeNode preNode = null;
    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        compareNode(root);

        return result;
    }

    private void compareNode(TreeNode node) {
        if (node == null) {
            return;
        }

        compareNode(node.left);

        if (preNode == null) {
            preNode = node;
        } else {
            if (preNode.val >= node.val) {
                result = false;
            }
            preNode = node;
        }

        compareNode(node.right);
    }
}
