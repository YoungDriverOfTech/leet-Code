package offer;

public class IsMatch {

    // 解析： https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
    // https://www.bilibili.com/video/BV1CK411c7gx?p=16
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // 这里加1是为了防止s和p都为空的case
        // f[i][j] 代表 A 的前 i 个和 B 的前 j 个能否匹配
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 总体的判断，分为空正则和非空正则的情况
                // 空正则的情况
                if (j == 0) {
                    // 空串和空正则是匹配的，f[0][0] = true
                    // 非空串和空正则必不匹配，f[1][0]=...=f[n][0]=false
                    f[i][j] = i == 0;
                } else {
                    // 非空正则的情况，分为p字符是*和非*的情况
                    // 非*的情况
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        // 为*的情况，分为看和不看两种情况
                        // 不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }

                        // 看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public boolean isMatch_1(String s, String p) {
        // 1. p最后是字符或者. 那么dp[i, j] = dp[i - 1, j - 1]
        // 2. p最后是*， 那么把p最后两位看成一个整体
        //      a. 如果p[n-2]p[n-1]=c 出现0次，那么最后两个字符作废，判断s[n-1]和p[n-3]，即dp[i, j] = dp[i, j - 2]
        //      b. 如果p[n-2]p[n-1]=c 出现多次，那么应该判断，s[n-2]和p[n-1]，即dp[i, j] = dp[i - 1, j]
        //

        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1]; // +1 for preventing i, j is 0

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 总体上需要判断匹配串是否为空
                // 如果匹配穿位空，字符串为空 = true; 字符串不为空 = false
                // dp[0][0] = true; dp[1][0] = false; dp[2][0] = false;
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    // 如果匹配串不是空，那就判断最后一个字符串是否位*
                    // 如果不是*的场合，dp[i, j] = dp[i - 1, j - 1]
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        // 如果是*的场合，那么就要看c出现过几次
                        // 出现0次 dp[i, j] = dp[i, j - 2]
                        // 出现多次dp[i, j] = dp[i - 1, j]

                        // 出现0次
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];   // 使用或等于，只要两种情况有一种是true，那么就是true
                        }

                        // 出现多次
                        if (i >= 1 && j >= 2    // 注意这里的条件 i大于 和 等于1，不要把1 忘了
                                && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        new IsMatch().isMatch_1("aa", "a*");
    }
}
