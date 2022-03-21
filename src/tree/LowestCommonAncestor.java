package tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归的找p和q是否存在于树中，现在可以分成三种情况
        // 1. p q分布在左右子树当中，那么公共节点就是跟节点
        // 2. p q分布在一侧子树当中，那么首先找到的节点就是他们的公共节点，看代码

        if (root == null || root == p || root == q) {
            return root;
        }

        // 分别在左右子树中进行查找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果都没有找到，说明没有公共节点
        if (left == null && right == null) {
            return null;
        }

        // 如果只有一侧有，那么就只有这一侧的节点是公共节点
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // 如果分布在两侧，那么跟节点就是公共节点
        return root;
    }
}
