package orderbyasc;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int curVal = 1;
        int[][] res = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (true) {
            // left -> right
            for (int i = left; i <= right; i++) {
                res[top][i] = curVal++;
            }
            if (++top > bottom) {
                break;
            }

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                res[i][right] = curVal++;
            }
            if (--right < left) {
                break;
            }

            // right -> left
            for (int i = right; i >= left; i--) {
                res[bottom][i] = curVal++;
            }
            if (--bottom < top) {   // 注意，这里是退出条件，别搞混了
                break;
            }

            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                res[i][left] = curVal++;
            }
            if (++left > right) {
                break;
            }
        }

        return res;
    }
}
