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

    public String longestPalindrome_1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 记录回文串开始坐标和长度，用于最后截取字符串
        int begin = 0;
        int maxLen = 1; // 至少要截取一个字符

        // dp初始化，单个字符是回文串
        // dp[i][i],表示字符串【i，i】之间是否是回文串，左闭右闭
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 先遍历长度，然后根据长度算出右区间
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len - 1; i++) { // 做指针没有必要遍历到最后一个，因为右指针会指向最后一个
                // 因为 L = j - i + 1. -> j = i + L -1
                int j = i + L - 1;
                if (j >= len) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 如果两个字符相等，且长度为小于等于3，则认定为是回文，比如aa， aba
                    if (L <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];    // 两头相等了应该往中间check
                    }
                }

                // 如果当前左右指针执行的字符字串是回文，那么就记录开始位置和长度
                if (dp[i][j] && maxLen < L) {
                    begin = i;
                    maxLen = L;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome_1("bb");
    }
}
