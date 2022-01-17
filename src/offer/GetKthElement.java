package offer;

public class GetKthElement {

    /**
 // 打印中序遍历倒序
 void dfs(TreeNode root) {
     if(root == null) return;
     dfs(root.right); // 右
     System.out.println(root.val); // 根
     dfs(root.left); // 左
 }
     * */

    int result;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.right);

        this.k--;
        if (this.k == 0) {
            this.result = node.val;
        }

        dfs(node.left);
    }
}
