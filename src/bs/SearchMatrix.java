package bs;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (target > num) {
                row++;
            } else if (target < num) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
