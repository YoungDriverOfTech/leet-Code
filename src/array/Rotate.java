package array;

public class Rotate {
    // https://leetcode.cn/problems/rotate-image/solution/-by-huan-huan-20-8df6/
    // 先按照对角线交换两侧元素，然后反转每一行
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tem = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tem;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tem = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[i][j];
                matrix[i][j] = tem;
            }
        }
    }
}
