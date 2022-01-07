package offer;

public class FindNumberIn2DArray {

    // my solution
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] secondMatrix = matrix[i];
            for (int j = 0; j < secondMatrix.length; j++) {
                if (target == secondMatrix[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // better solution: find number from right-top corner
    // column - 1, if corner element larger than target
    // row + 1, if corner element smaller than target
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target > matrix[row][column]) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

//        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix, 5));
//        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix, 20));

        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray_1(matrix, 5));
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray_1(matrix, 20));
    }
}
