package backtrack;

public class Exist {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int kIndex) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(kIndex)) {
            return false;
        }

        // 已经查找到最后一个，返回true
        if (kIndex == word.length() - 1) {
            return true;
        }

        char originalChar = word.charAt(kIndex);
        board[i][j] = '#';

        boolean result = dfs(i - 1, j, board, word, kIndex + 1) ||
                dfs(i + 1, j, board, word, kIndex + 1) ||
                dfs(i, j - 1, board, word, kIndex + 1) ||
                dfs(i, j + 1, board, word, kIndex + 1);

        board[i][j] = originalChar;

        return result;
    }
}
