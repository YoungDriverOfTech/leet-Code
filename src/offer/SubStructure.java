package offer;

public class SubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }

        if (A.val == B.val && isValueEquals(A, B)) { // check method must executed in if, cause node value may be duplicate
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isValueEquals(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return isValueEquals(root1.left, root2.left) && isValueEquals(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode aTreeNode = new TreeNode(1);
        TreeNode aTreeNodeLeft = new TreeNode(2);
        TreeNode aTreeNodeRight = new TreeNode(3);
        aTreeNode.left = aTreeNodeLeft;
        aTreeNode.right = aTreeNodeRight;

        TreeNode bTreeNode = new TreeNode(3);
        TreeNode bTreeNodeLeft = new TreeNode(1);
        bTreeNode.left = bTreeNodeLeft;
        System.out.println(new SubStructure().isSubStructure(aTreeNode, bTreeNode));

//        TreeNode aTreeNode = new TreeNode(3);
//        TreeNode aTreeNodeLeft = new TreeNode(4);
//        TreeNode aTreeNodeRight = new TreeNode(5);
//        aTreeNode.left = aTreeNodeLeft;
//        aTreeNode.right = aTreeNodeRight;
//        TreeNode aTreeNodeLeftSon = new TreeNode(1);
//        TreeNode aTreeNodeRightSon = new TreeNode(2);
//        aTreeNodeLeft.left = aTreeNodeLeftSon;
//        aTreeNodeLeft.right = aTreeNodeRightSon;
//
//        TreeNode bTreeNode = new TreeNode(4);
//        TreeNode bTreeNodeLeft = new TreeNode(1);
//        bTreeNode.left = bTreeNodeLeft;
//        System.out.println(new SubStructure().isSubStructure(aTreeNode, bTreeNode));
    }
}
