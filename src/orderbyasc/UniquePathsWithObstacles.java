package orderbyasc;

public class UniquePathsWithObstacles {
    // 动态规划
    // https://leetcode-cn.com/problems/unique-paths-ii/solution/63-bu-tong-lu-jing-ii-by-chen-wei-f-qmzs/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 此题用dp来解，对于某一个单元格来说，可以由上或者左边转移过来，即到达本单元格的path = 左单元格path + 上单元格path
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        // dp[i] 表示某一列的单元格的path数量,不用声明二维的，因为换到下一行的时候，dp本身就代表着上一行的状态，这时候只需要挂心列就可以
        int[] dp = new int[cols];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0; // 如果出口就有障碍物，那么一开始的状态就是路径为0条

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[cols - 1];
    }

    public int uniquePathsWithObstacles_1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {    // 一旦在初始化首行或者首列的时候，一旦出现了障碍，则后面的元素路径都是0
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {    // 一旦在初始化首行或者首列的时候，一旦出现了障碍，则后面的元素路径都是0
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /***
     * dfs overtime
     *     private int res = 0;
     *
     *     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     *         dfs(obstacleGrid, 0, 0);
     *         return res;
     *     }
     *
     *     private void dfs(int[][] obstacleGrid, int i, int j) {
     *         if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
     *             return;
     *         }
     *
     *         // 如果已经到达最后一个单元格，那么给结果+1后返回
     *         if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
     *             if (obstacleGrid[i][j] == 0) {
     *                 res++;
     *             }
     *         }
     *
     *         // 向右边和下边继续走
     *         dfs(obstacleGrid, i + 1, j);
     *         dfs(obstacleGrid, i, j + 1);
     *     }
     *
     */
}
