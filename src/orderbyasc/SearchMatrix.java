package orderbyasc;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始找，比右上角大的 行数+1， 否则列数-1
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
