package hot100;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        // 初始化第一行第一列
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 从坐标1，1开始遍历，每次把和当前单元格左边或上边较小的数相加
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols- 1];
    }
}
