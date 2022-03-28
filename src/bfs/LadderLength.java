package bfs;

import java.util.*;

public class LadderLength {
    // 此题是图的广度遍历的标准写法，需要背诵
    // https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1 先把wordList放入hash表中，为了快速判断，某个字符串是不是在hash表中
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);  // 因为开始字符串不一定在set中，所以先进一次去除操作

        // 2 图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>(); // 本来应该用boolean，但是此题是字符串，所以用字符串的set
        visited.add(beginWord);

        // 3 开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            // 因为队列的长度会一直变化，所以就像层序遍历树结构一样，需要提前拿出需要遍历的数组个数
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();

                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }

        return 0;
    }

    // 一次改变当前字符串的每一个字符，然后判断wordSet中有没有存在，如果存在说明可以被算作路径
    private boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {

        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // 先保存当前字符，因为带回需要恢复回来
            char originalChar = charArray[i];

            // 一次替换26个字符，判断替换后是否是wordset里面存在
            for (char k = 'a'; k <= 'z'; k++) {
                if (originalChar == k) {
                    continue;
                }

                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }

                    // 只有没有被访问过的单词，才能被放进队列里面
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }

            // 恢复原来的字符
            charArray[i] = originalChar;
        }

        return false;
    }
}
