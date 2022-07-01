package orderbyasc;

import top200.Solution;

public class SearchMatrix {

    // O(n+m)
    // O(1)
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

    // 把二维数组看成一维数组，用二分查找
    // O(log(m∗n))
    // O(1)
    public boolean searchMatrix_1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;

            // 重要的是怎么把一维数组的坐标，转换成二维的
            // mid / n 是将一维数组的索引转成二维数组的行坐标  （注意，这个n是列数，即每一行的元素个数）
            // mid % n 是将一维数组的索引转成二维数组的列坐标  （注意，这个n是列数，即每一行的元素个数）
            int x = matrix[mid / n][mid % n];


            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
