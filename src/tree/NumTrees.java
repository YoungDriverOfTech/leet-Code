package tree;

import java.util.HashMap;
import java.util.Map;

public class NumTrees {
    private Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        // 使用map是为了防止重复的计算，浪费了时间
        if (map.containsKey(n)) {
            return map.get(n);
        }

        // 遍历数组，某个跟节点的左子树节点数量是i-1, 右子树节点数量是n-i
        // 那么找到左子树和右子树的节点数量，然后相乘就是结果
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            count += leftNum * rightNum;
        }

        map.put(n, count);
        return count;
    }

    // dp
    // 首先二叉树有根节点，和孩子节点（有可能为空）。假设根节点为i，那么1 到 (i - 1) 一定是在根节点的左子树上，i + 1 到 n 一定是在根节点的右子树上，这个是利用的二叉排序树的性质。
    // 我们依次选取1，2，...，n作为根节点。 假设现在选取i作为根节点，那么左子树就有(i - 1) 个节点， 右子树就有 n - i 个节点，
    // 那么此时的数量就是左子树二叉排序树的数量 * 右子树二叉排序的数量；从而可以求得总数
    // dp数组的定义, dp[i]表示i个节点组成的不同二叉排序树的总数
    // 递推公式 ： dp[n] = dp[0] * dp[i - 1] + dp[1] * dp[i - 2] + dp[2] * d[i - 3] + ... + dp[i - 1] * dp[0];
    // https://leetcode.cn/problems/unique-binary-search-trees/solution/c-by-xuezhaplus-f5mt/
    public int numTrees_1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                // dp[i]中的i表示一共有多少个节点，并且这个i是包含根节点数量的，以i==2为例
                // 当j第一次遍历的时候： dp[2] += dp[0] + dp[1]  表示左边没有节点，右边有一个，加上跟节点的话总数就是2个
                // 当j进行下一次计算的时候： dp[2] += dp[1] + dp[0]  表示左边有一个，右边没有节点，加上跟节点的话总数就是2个
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
