package bfs;

public class Solve {
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int columns = board[0].length;

        // 把边界上面的O换成别的字符
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean isBorder = i == 0 || j == 0 || i == rows - 1 || j == columns - 1;
                if (isBorder && board[i][j] == 'O') {
                    dfs(board, i, j, rows, columns);
                }
            }
        }

        // 把O换成X
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int rows, int columns) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = '#';
        }

        dfs(board, i + 1, j, rows, columns);
        dfs(board, i - 1, j, rows, columns);
        dfs(board, i, j + 1, rows, columns);
        dfs(board, i, j - 1, rows, columns);
    }
}
