package tree;

public class Flatten {

    // 后序遍历
    // https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/comments/
    // 将节点的右子树放在左子树下，递归处理
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将原来的左子树挂在根结点的右端
        root.left = null;
        root.right = left;

        // 遍历到先前节点右子树的末端，然后将原来的右子树链接到末端
        TreeNode p = root;
        while(p.right!=null){
            p = p.right;
        }
        p.right = right;
    }
}
