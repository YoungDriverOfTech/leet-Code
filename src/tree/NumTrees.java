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
    // https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
    // https://leetcode.cn/problems/unique-binary-search-trees/solution/c-by-xuezhaplus-f5mt/
    public int numTrees_1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j < i + 1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
