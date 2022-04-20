package hot100;

import dfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob {
    //
    // 正确的想法应该是，如果要偷当前节点，那么就要偷当前节点左右节点下面的左右节点
    // 如果不偷当前节点，那么只需要头当前节点的左右节点即可
    // 超时了
    public int rob_1(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += (rob_1(root.left.left) + rob_1(root.left.right));
        }

        if (root.right != null) {
            money += (rob_1(root.right.left) + rob_1(root.right.right));
        }

        return Math.max(money, rob_1(root.left) + rob_1(root.right));
    }

    // 上述解法的问题
    // 针对解法一种速度太慢的问题，经过分析其实现，我们发现爷爷在计算自己能偷多少钱的时候，同时计算了 4 个孙子能偷多少钱，
    // 也计算了 2 个儿子能偷多少钱。这样在儿子当爷爷时，就会产生重复计算一遍孙子节点。
    // 用Map来记录每个节点对应的最大值
    public int rob_2(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    private int robInternal(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) {
            return memo.get(root);
        }


        int money = root.val;
        if (root.left != null) {
            money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
        }

        if (root.right != null) {
            money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
        }
        int maxAmount = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));

        // 把计算出来的某个节点对应的最大值，让入map中
        memo.put(root, maxAmount);
        return maxAmount;
    }

    // todo https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
    // todo u需要看看解法3
}
