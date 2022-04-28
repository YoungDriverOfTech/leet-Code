package orderbyasc;

import dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);

        res.add(node.val);
    }
}
