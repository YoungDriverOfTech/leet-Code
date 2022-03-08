package hash;

import java.util.ArrayList;
import java.util.List;

public class SolveSudoku {

    // https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode-solution/
    // 定义行/列/盒子的数组，用来表示当前填入的数字是否是有效的
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] boxes = new boolean[3][3][9];
    private boolean valid = false;  // 表示递归的时候，最终结果是否是有效的
    private List<int[]> list = new ArrayList<>(); // 用来装没有被填充过的坐标

    public void solveSudoku(char[][] board) {
        // 遍历board，把没有被填充过的坐标装进list，并且把已经填充过的flag设置为true
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;  // 因为取出来的范围是1-9，但是现在应该是计算索引，所以需要减去1
                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[i / 3][j / 3][digit] = true;
                }
            }
        }

        // 递归遍历
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == list.size()) {
            valid = true;
            return;
        }

        // 取出还没有被填充数字的所有坐标
        int[] indexes = list.get(pos);
        int x = indexes[0];
        int y = indexes[1];

        // 把数字1-9，依次填入board中，直到满足条件后退出
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!rows[x][digit] && !cols[y][digit] && !boxes[x / 3][y / 3][digit]) {
                rows[x][digit] = true;
                cols[y][digit] = true;
                boxes[x / 3][y / 3][digit] = true;

                board[x][y] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);

                rows[x][digit] = false;
                cols[y][digit] = false;
                boxes[x / 3][y / 3][digit] = false;
            }

        }
    }
}
