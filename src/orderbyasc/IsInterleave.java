package orderbyasc;

public class IsInterleave {

    // https://leetcode-cn.com/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/
    public boolean isInterleave(String s1, String s2, String s3) {
        // 如果长度加起来不等的话，那么直接返回false
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        // dp[i][j] 表示s1【0，i】和s2【0，j】可以于s3【0， i + j】匹配起来
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        // 转移方程，有以下几种情况
        // 1. 如果s1是空串，那么就靠s2和s3匹配 dp[0][j] = s2[j] == s3[j]
        // 2. 如果s2是空串，那么就靠s1和s3匹配 dp[i][0] = s1[i] == s3[i]
        // 3. 如果s1，s2不是空串，那么s3要分别和s1，s2匹配。
        // dp[i][j] = (dp[i - 1][j] && s1[i] == s3[i - 1 + j]) || (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1])

        // 初始化1，2
        for (int j = 1; j <= len2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            } else {    // 如果已经找到了一个等于的字串，后面的结果直接都是false，因为如果后面还有true，会对3的转移有影响
                break;
            }
        }
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {    // 如果已经找到了一个等于的字串，后面的结果直接都是false，因为如果后面还有true，会对3的转移有影响
                break;
            }
        }

        // 转移3
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len1][len2];
    }
}
