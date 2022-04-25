package top200;

public class IsMatch {
    // Key: // 要实时记住dp里面的i，j代表的是基于1的位置，字符串里面的i是基于0的索引
    // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配 (true 的话表示匹配)
    // 状态转移方程：
    //      1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
    //      2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]    其中：
    //      dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
    //      dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
    // 初始化：
    //      1. dp[0][0] 表示什么都没有，其值为 true
    //      2. 第一行 dp[0][j]，换句话说，s 为空，与 p 匹配，所以只要 p 开始为 * 才为 true
    //      3. 第一列 dp[i][0]，当然全部为 false
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];   // 为预防空串
        dp[0][0] = true; // 空串和空正则是匹配的

        for (int i = 1; i <= len2; i++) {
            // 如果匹配串的字符p[i]是*，且字符串是空串的话，那么说明是匹配的，那么说明当前这个字符是匹配任何字符串的，那么具体的结果
            // 就取决于p字符串前面的部分和s字符串匹配不匹配，即dp[0][i - 1]
            // 至于为什么i-1，是因为i表示的是字符串的位置（base 1），-1是位置找到索引
            // 要实时记住dp里面的i，j代表的是基于1的位置，字符串里面的i是基于0的索引
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
                // 说明当前字符匹配上了，具体的结果呢，取决于前面字符串的匹配情况
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // 2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
                // dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
                // dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[len1][len2];
    }
}
