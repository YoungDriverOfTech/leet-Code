package first200;

public class LongestIncreasingPath {

    // 带记忆的dfs
    // https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/java-dfs-you-hua-di-gui-shi-pin-jiang-jie-dai-ma-j/
    private int[][] matrix;
    private int rows;
    private int cols;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] max;
    private int maxLen = 0;

    public int longestIncreasingPath(int[][] matrix) {

        // 初始化一些变量
        rows = matrix.length;
        cols = rows == 0 ? 0 : matrix[0].length;
        this.matrix = matrix;
        max = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (max[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        return maxLen;
    }

    private int dfs(int i, int j) {
        if (max[i][j] != 0) {
            return max[i][j];
        }

        max[i][j] = 1;

        // 从四个方向上去遍历矩阵
        for (int k = 0; k < 4; k++) {
            int newX = i + dirs[k][0];  // 不要忘记和原来的坐标相加
            int newY = j + dirs[k][1];  // 不要忘记和原来的坐标相加

            if (isValid(newX, newY) && matrix[newX][newY] > matrix[i][j]) {
                max[i][j] = Math.max(max[i][j], dfs(newX, newY) + 1);
            }
        }

        maxLen = Math.max(maxLen, max[i][j]);
        return max[i][j];
    }


    private boolean isValid(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return false;
        }

        return true;
    }



    // 传统dfs超时
    int result = -1;

    public int longestIncreasingPath_1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(matrix, i, j, -1, 0);
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, int i, int j, int curVal, int count) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= curVal || matrix[i][j] == -2) {
            return;
        }

        result = Math.max(result, count + 1);

        // 记录当前值，并且把当前值变换为-2
        curVal = matrix[i][j];
        matrix[i][j] = -2;

        dfs(matrix, i + 1, j, curVal, count + 1);
        dfs(matrix, i - 1, j, curVal, count + 1);
        dfs(matrix, i, j + 1, curVal, count + 1);
        dfs(matrix, i, j - 1, curVal, count + 1);

        matrix[i][j] = curVal;
    }
}
