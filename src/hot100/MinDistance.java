package hot100;

public class MinDistance {
    // https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
    // https://leetcode-cn.com/problems/edit-distance/solution/xiong-mao-shua-ti-python3-dong-tai-gui-hua-yi-dong/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 初始化DP
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        // 进行状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果两个字符相等，那么就不需要进行变化，直接等于前面的字符字串就行
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果执行的是插入操作，例如 word1:aa  word2:aab, 那么word1插入以后，b肯定相同，那么只需要比较word1[0, i]和word2[0, j - 1]即可
                    // 如果执行的是删除操作，例如 word1:aab  word2:aa, 那么删除以后需要比较word1[0, i - 1]和word2[0, j]
                    // 如果执行的是替换操作，例如 word1:aab  word2:aac, 那么替换以后需要比较word1[0, i - 1]和word2[0, j - 1]
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1; // +1是要加上本次操作
                }
            }
        }

        return dp[m][n];
    }
}
