package top200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tier {
    Tier[] children = new Tier[26];
    boolean isEnd = false;
}

// https://leetcode-cn.com/problems/word-search-ii/solution/tong-ge-lai-shua-ti-la-yi-ti-si-jie-zi-d-2igi/
public class FindWords {

    // 前缀和
    public List<String> findWords(char[][] board, String[] words) {

        // 使用set来去重
        Set<String> resultSet = new HashSet<>();

        // 用visited二维数组来标记某个单元格是否被访问过了
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 把word里面的每个单词，都对应成前缀树
        Tier root = buildTree(words);

        // dfs board
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(resultSet, board, i, j, visited, root, sb);
            }
        }

        return new ArrayList<>(resultSet);
    }

    private void dfs(Set<String> resultSet, char[][] board, int i, int j, boolean[][] visited,
                     Tier node, StringBuilder sb) {

        // check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] ||
                node.children[board[i][j] - 'a'] == null) {
            return;
        }

        // 如果已经查找到了最后一个元素，那么直接装进result里面返回即可
        sb.append(board[i][j]);
        if (node.children[board[i][j] - 'a'].isEnd) {   // 判断的条件不能是node.isEnd
            resultSet.add(sb.toString());
//            return;   注意，这里不能接上return，
        }

        // 把当前字符设置为已被查找过的元素，然后上下左右四个方向去查找剩余字符
        visited[i][j] = true;

        dfs(resultSet, board, i + 1, j, visited, node.children[board[i][j] - 'a'], sb);
        dfs(resultSet, board, i - 1, j, visited, node.children[board[i][j] - 'a'], sb);
        dfs(resultSet, board, i, j + 1, visited, node.children[board[i][j] - 'a'], sb);
        dfs(resultSet, board, i, j - 1, visited, node.children[board[i][j] - 'a'], sb);

        // 恢复状态
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private Tier buildTree(String[] words) {
        Tier root = new Tier();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Tier node = root;

            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Tier();
                }
                node = node.children[index];
            }

            node.isEnd = true;
        }

        return root;
    }


    // 深度优先， 超时
    public List<String> findWords_1(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        // 所有的单词，都需要拿出来放入单词表盘中去查找
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 进入单词表盘中去搜索
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[0].length; k++) {
                    if (dfs(board, j, k, word, 0) && !result.contains(word)) {
                        result.add(word);
                    }
                }
            }
        }

        return result;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int wordIndex) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(wordIndex)) {
            return false;
        }

        if (wordIndex == word.length() - 1) {
            return true;
        }

        // 查找四个方向，只要有一个满足，那么就可以返回true
        board[x][y] = '#';

        boolean res = false;
        res = dfs(board, x + 1, y, word, wordIndex + 1) ||
                dfs(board, x - 1, y, word, wordIndex + 1) ||
                dfs(board, x, y + 1, word, wordIndex + 1) ||
                dfs(board, x, y - 1, word, wordIndex + 1);

        board[x][y] = word.charAt(wordIndex);

        return res;
    }

}
