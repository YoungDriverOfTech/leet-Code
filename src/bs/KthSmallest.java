package bs;

public class KthSmallest {
    // 根据题意，矩阵左上角数值最小，右下角最大，他们我们最左上右下进行二分查找，找出中间的值mid，然后统计小于mid的值有多少个count
    // 如果 count >= k ---> 说明mid大了(或者等于)，应该把右指针左移 right = mid
    // 如果 count < k ---> 说明mid小了，应该把左指针往右移 left = mid + 1
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[rows - 1][cols - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 计算有多少个数字小于mid
            int lesserThanK = getCount(matrix, mid);

            // 大于等于k，说明mid选大了，把右边界缩小
            if (lesserThanK >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int getCount(int[][] matrix, int mid) {
        // 按照列来进行查找，每次都找列的对后一个元素（从左到右），如果列的最大的元素都小于mid的话，说明整列都应该算入count
        // 如果列最大元素大于mid的话，应该把行-1，然后继续判断
        int n = matrix.length;
        int count = 0;
        int row = n - 1;    // 行是最后一行，列是第一列
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
