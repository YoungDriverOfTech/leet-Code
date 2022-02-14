package string;

public class LongestPalindrome {

    // explanation: https://www.bilibili.com/video/BV1iX4y1c7ai?from=search&seid=2542301756001179537&spm_id_from=333.337.0.0
    public String longestPalindrome(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j] 表示i和j坐标之间的字串是否是回文串
        String result = "";

        for (int len = 0; len < n; len++) {     // 遍历字串的区间，从1个字符开始，一直到所有的字符
            for (int i = 0; i + len < n; i++) { // i是开始索引，k是字符串的结束索引
                int j = i + len;

                if (len == 0) { // 只有一个字符的时候
                    dp[i][j] = true;
                } else if (len == 1) {  // 有两个字符的时候
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // 转移方程，比如abcba,先判断两边的a是否相同，如果相同那么就判断去掉两边a的字串是否是回文串
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && len + 1 > result.length()) {    // 因为数组是0基的，所以需要长度+1
                    result = s.substring(i, i + len + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("cbbd");
    }
}
