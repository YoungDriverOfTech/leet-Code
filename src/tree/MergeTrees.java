package tree;

public class MergeTrees {

    // https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    public static void main(String[] args) {
        TreeNode leftTreeNode1 = new TreeNode(1);
        TreeNode leftTreeNode3 = new TreeNode(3);
        TreeNode leftTreeNode2 = new TreeNode(2);
        TreeNode leftTreeNode5 = new TreeNode(5);
        leftTreeNode1.left = leftTreeNode3;
        leftTreeNode1.right = leftTreeNode2;
        leftTreeNode3.left = leftTreeNode5;

        TreeNode rightTreeNode2 = new TreeNode(2);
        TreeNode rightTreeNode1 = new TreeNode(1);
        TreeNode rightTreeNode3 = new TreeNode(3);
        TreeNode rightTreeNode4 = new TreeNode(4);
        TreeNode rightTreeNode7 = new TreeNode(7);
        rightTreeNode2.left = rightTreeNode1;
        rightTreeNode2.right = rightTreeNode3;
        rightTreeNode1.right = rightTreeNode4;
        rightTreeNode3.right = rightTreeNode7;


        new MergeTrees().mergeTrees(leftTreeNode1, rightTreeNode2);
    }
}
