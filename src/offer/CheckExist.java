package offer;

public class CheckExist {
    public boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] words, int k) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != words[k]) {
            return false;
        }

        if (k == words.length - 1) {
            return true;
        }

        board[i][j] = '\0'; // change the board value for preventing duplicate check

        // check the four directions of board[i][j] match word[k + 1]
        boolean result = dfs(board, i + 1, j, words, k + 1)
                || dfs(board, i - 1, j, words, k + 1)
                || dfs(board, i, j + 1, words, k + 1)
                || dfs(board, i, j - 1, words, k + 1);  // 直接拷贝的话，注意不要把条件写错了

        // recovery old value when deep search check is finished.(from top-left corner of board)
        // when this line is executed which indicates match the word[k] correctly
        board[i][j] = words[k];

        return result;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        String word = "ABCCED";

        System.out.println(new CheckExist().exist(board, word));
    }
}
