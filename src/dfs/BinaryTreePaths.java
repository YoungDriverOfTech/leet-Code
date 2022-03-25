package dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(result, root, "");
        return result;
    }

    private void dfs(List<String> result, TreeNode node, String path) {
        if (node == null) {
            return;
        }

        path += node.val;

        // 判断是否到了叶节点
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path += "->";
            dfs(result, node.left, path);
            dfs(result, node.right, path);
        }
    }
}
