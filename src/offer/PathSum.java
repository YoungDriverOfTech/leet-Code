package offer;

import java.util.LinkedList;
import java.util.List;

public class PathSum {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> paths = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return result;
    }

    // 深度优先
    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        paths.add(root.val);

        if (root.left == null && root.right == null && target == 0) {
            // must use constructor to deep copy
            result.add(new LinkedList<>(paths));
        }

        // search left paths
        dfs(root.left, target);
        dfs(root.right, target);

        // back to parent node and check another one child node
        paths.removeLast();
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(1);
        TreeNode childLeft = new TreeNode(2);
        TreeNode childRight = new TreeNode(3);
        parent.left =childLeft;
        parent.right = childRight;


        List<List<Integer>> lists = new PathSum().pathSum(parent, 5);
        System.out.println();
    }
}
