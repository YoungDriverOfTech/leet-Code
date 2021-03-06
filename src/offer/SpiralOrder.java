package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {

    public int[] spiralOrder_1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        // result and index
        int x = 0;
        int[] result = new int[matrix.length * matrix[0].length];

        while (true) {
            // left -> right
            for (int i = left; i <= right; i++) {
                result[x++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                result[x++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }

            // right -> left
            for (int i = right; i >= left; i--) {
                result[x++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                break;
            }

            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                result[x++] = matrix[i][left];
            }
            if (right < ++left) {
                break;
            }
        }
        return result;
    }

    // my solution
    // 重新做的时候优化一下代码，参考：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        // 统计树组一共右多少个元素，在递归调用的时候这个树枝会递减，减到0的时候会退出递归
        int count = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>();
        dfs(matrix, 0, 0, result, count);

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }

        return array;
    }

    private void dfs(int[][] matrix, int row, int column, List<Integer> result, int count) {
        if (count == 0) {
            return;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        // left -> right
        while (column < columns && matrix[row][column] != Integer.MIN_VALUE) {
            if (count > 0) {
                int element = matrix[row][column];
                result.add(element);
                matrix[row][column] = Integer.MIN_VALUE;
                column++;
                count--;
            }
        }

        row++;
        column--;
        // top -> bottom
        while (row < rows && matrix[row][column] != Integer.MIN_VALUE) {
            if (count > 0) {
                int element = matrix[row][column];
                result.add(element);
                matrix[row][column] = Integer.MIN_VALUE;
                row++;
                count--;
            }
        }

        // right -> left
        column--;
        row--;
        while (column >= 0 && matrix[row][column] != Integer.MIN_VALUE) {
            if (count > 0) {
                int element = matrix[row][column];
                result.add(element);
                matrix[row][column] = Integer.MIN_VALUE;
                column--;
                count--;
            }
        }

        // bottom -> top
        row--;
        column++;
        while (row >= 0 && matrix[row][column] != Integer.MIN_VALUE) {
            if (count > 0) {
                int element = matrix[row][column];
                result.add(element);
                matrix[row][column] = Integer.MIN_VALUE;
                row--;
                count--;
            }
        }
        row++;
        column++;

        dfs(matrix, row, column, result, count);
    }

    public static void main(String[] args) {
        int[][] param = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(param)));
    }
}
