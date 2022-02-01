package offer;

public class IsMatch {

    // 解析： https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // 这里加1是为了防止s和p都为空的case
        // f[i][j] 代表 AA 的前 ii 个和 BB 的前 jj 个能否匹配
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
}
