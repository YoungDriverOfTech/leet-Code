package hot100;

public class CountSubstrings {
    public int countSubstrings(String s) {
        // 动态规划,dp代表从i到j之间的字符串是否为回文
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int res = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {

                // 这个转移方程的含义
                // 1. 如果有单个字符，就算回文
                // 2. 如果两个字符相等，比如aa，也算回文
                // 3. 如果有字串左右边界相等，且出去左右边界，里面的串也是回文的话，那么也算回文，比如aba
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}
