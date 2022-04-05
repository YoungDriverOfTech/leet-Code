package first200;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (true) {
            // left -> right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }

            // right -> left
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (top > --bottom) {
                break;
            }

            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (right < ++left) {
                break;
            }
        }
        return result;
    }
}
