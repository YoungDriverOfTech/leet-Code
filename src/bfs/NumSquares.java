package bfs;

public class NumSquares {
    // 找到n前面最大的一个完全平方数K，记为一个个数；那么 还剩n-K*K, 也就是说只要将n-k*k的解dp[n-k*k] 加上上面那个1，就是n的解，这就是最短的。
    // https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏有i中情况

            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
