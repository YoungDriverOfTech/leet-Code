package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathLeft = getPath(root, p);
        List<TreeNode> pathRight = getPath(root, q);

        TreeNode ancestor = null;
        for (int i = 0; i < pathLeft.size() && i < pathRight.size(); i++) {
            if (pathLeft.get(i) == pathRight.get(i)) {
                ancestor = pathLeft.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }


    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        TreeNode result = root;
        List<TreeNode> resultList = new ArrayList<>();

        while (result != target) {
            resultList.add(result);
            if (target.val > result.val) {
                result = result.right;
            } else {
                result = result.left;
            }
        }

        // add target self
        resultList.add(result);
        return resultList;
    }
}
