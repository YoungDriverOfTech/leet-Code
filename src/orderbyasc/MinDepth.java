package orderbyasc;

import dfs.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // calculate left and right tree depth
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // return sum of leftDepth and rightDepth if one of them is 0,
        // return the smaller one depth if neither of them is 0
        return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    }
}
