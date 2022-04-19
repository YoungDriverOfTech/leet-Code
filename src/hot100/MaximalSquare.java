package hot100;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
        if (matrix == null || rows == 0 || cols == 0) {
            return res;
        }

        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;    // 不要忘记+1，这个+1是自己本身
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}
