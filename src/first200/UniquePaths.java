package first200;

public class UniquePaths {
    // https://leetcode-cn.com/problems/unique-paths/solution/62-bu-tong-lu-jing-tu-jie-dong-tai-gui-h-2b0k/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                if (i != 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j != 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
