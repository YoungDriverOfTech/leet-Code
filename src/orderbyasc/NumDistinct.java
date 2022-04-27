package orderbyasc;

public class NumDistinct {
    public int numDistinct(String s, String t) {
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
