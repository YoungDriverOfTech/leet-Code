package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> paths = new LinkedList<>();
        dfs(result, paths, root, target);

        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> paths, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        paths.add(root.val);

        if (root.left == null && root.right == null && target == 0) {
            result.add(new LinkedList<Integer>(paths));
        }

        dfs(result, paths, root.left, target);
        dfs(result, paths, root.right, target);

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
