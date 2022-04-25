package orderbyasc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    // https://leetcode-cn.com/problems/n-queens/solution/n-huang-hou-java-by-sui-ji-guo-cheng-sui-q0ot/
    // 其实题目可以改成，在每一行放置一个皇后，让这些皇后不能相互攻击。（因为每一行最多只有一个皇后）
    private List<List<String>> res;

    public int totalNQueens(int n) {
        res = new ArrayList<>();

        // 先做成一个棋盘，里面全部用'.'来填充
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // 用回溯法把结果添加进res
        backTrack(board, 0);

        return res.size();
    }

    private void backTrack(char[][] board, int row) {
        // 如果行数已经天充满了最后一行，那么就行进结果添加
        if (board.length == row) {
            res.add(charToList(board));
            return;
        }

        // 开始回溯
        int cols = board[row].length;
        for (int i = 0; i < cols; i++) {

            // 当前位置如果不合法，那么就进行下一列位置的判断
            if (!isValid(board, row, i)) {
                continue;
            }

            // 回溯过程
            board[row][i] = 'Q';

            backTrack(board, row + 1);

            board[row][i] = '.';
        }
    }

    private List<String> charToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] ch : board) {
            result.add(new String(ch));
        }
        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        // 因为我们的逻辑是每一行只放一个皇后，所以这个皇后的左边和右边不需要进行检查了。
        // 因为我们是一行一行从上向下放置皇后，所以下方，左下方和右下方不会有皇后（还没放皇后）。
        // 最后我们需要检查的只有上方、左上和右上三个方向。

        // 检查该列是否有冲突
        int rows = board.length;
        int cols = board[row].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < cols; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
