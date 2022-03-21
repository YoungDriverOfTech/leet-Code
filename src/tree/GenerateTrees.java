package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateTrees {
//    所以如果求 1...n 的所有可能。
//    我们只需要把
//            1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
//            2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
//            3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
//            4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
//            ...
//    n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
//    至于，[ 2 ... n ] 的所有可能以及 [ 4 ... n ] 以及其他情况的所有可能，可以利用上边的方法，把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。
//    如果只有一个数字，那么所有可能就是一种情况，把该数字作为一棵树。而如果是 [ ]，那就返回 null。

    // https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-7/
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }

        // 只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }

        // 尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            // 获取左子树和右子树
            List<TreeNode> left = getAns(start, i - 1);
            List<TreeNode> right = getAns(i + 1, end);

            // 组合左右子树
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
