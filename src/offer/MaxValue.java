package offer;

public class MaxValue {

    // explanation details: https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/

    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // initialize first row
        for (int i = 1; i < columns; i++) {  // PS: i < columns, not rows
            grid[0][i] += grid[0][i - 1];
        }

        // initialize first column
        for (int i = 1; i < rows; i++) {  // PS: i < rows, not columns
            grid[i][0] += grid[i - 1][0];
        }

        // get the max value
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int[][] params = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] params2 = {
                {1, 2, 5},
                {3, 2, 1},
        };

        System.out.println(new MaxValue().maxValue(params));
        System.out.println(new MaxValue().maxValue(params2));
    }
}
