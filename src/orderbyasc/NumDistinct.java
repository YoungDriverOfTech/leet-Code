package orderbyasc;

public class NumDistinct {

    // 普遍DP解法
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return 0;
        }

        // dp[i][j]代表s[0, i]和t[0, j]，匹配的字串个数
        // 当s[i-1] != t[j-1]时，有dp[i][j] = dp[i-1][j]  -> 当前字符不相等的话，那么就得看s[0, i - 1]和t[0, j]的匹配数量有多少
        // 当s[i-1] == t[j-1]时，有dp[i][j] = dp[i][j] = dp[i-1][j-1] + dp[i-1][j]  -> 当前字符相等的话，那么就得看s[0, i - 1]和t[0, j - 1]的匹配数  +  s[0, i - 1]和t[0, j]的匹配数

        // 分别初始化t，s为空的情况
        // j==0时，dp[i][0] = 1
        // i==0时，dp[0][j] = 0
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sLen][tLen];
    }

    // 一维数组解法
    public int numDistinct_1(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return 0;
        }

        // dp[i][j] represents numbers of s[0,i] euqals t[0,j]
        int[][] dp = new int[sLen + 1][tLen + 1];

        // initailize dp, when t is empty, any string equals t
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLen][tLen];
    }
}
