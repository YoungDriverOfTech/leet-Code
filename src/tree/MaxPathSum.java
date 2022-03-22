package tree;

public class MaxPathSum {
    // https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 获得左右子树的和
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftSum = Math.max(getSum(node.left), 0);
        int rightSum = Math.max(getSum(node.right), 0);

        // 获得当前节点及其子树的和
        int currentSum = node.val + leftSum + rightSum;

        // 更新最大值
        maxSum = Math.max(maxSum, currentSum);

        // 返回当前节点的最大的和
        return node.val + Math.max(leftSum, rightSum);
    }
}
