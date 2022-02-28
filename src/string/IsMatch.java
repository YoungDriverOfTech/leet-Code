package string;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        // dp[i][j]
        // last letter: !*  then dp[i][j] = dp[i - 1][j - 1]
        // last letter: *
        //   0 time:   dp[i][j] = dp[i][j - 2];
        //  >1 time:   dp[i][j] = dp[i - 1][j];

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; // plus 1 is for preventing  m/n is zero

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // if p is empty, then dp[0][0] = true, dp[1][0] = false; ...
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    // if last letter of p is not *
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }

                    } else {

                        // if last letter of p is *, then we should consider how many times * and previous letter show
                        // for 0 time
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }


                        // for >0 times
                        if ((i >= 1 && j >= 2) && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') ) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }

        return dp[m][n];
    }


    // 匹配的时候要考虑的是，先匹配当前的字符，如果当前的字符已经匹配的话，那么结果就取决去前一个字符匹配的结果
    public boolean isMatch_1(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 因为p q有可能是空串，所以需要把长度多+1
        // dp[i][j] i和j代表的是字符串的长度， dp[i][j]代表的是是否能匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // 空字符串和空正则是匹配的，所以为true

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {  // j不从0开始是因为非空串和空正则不匹配，默认都为false
                // 当前的正则字符如果是*，那么就需要分为两种情况
                // a.如果出现0次
                //      p[j]和p[j - 1]的组合出现0次，那么就需要匹配s[i]和p[j - 2] -> dp[i][j] = dp[i][j - 2]
                // b.如果出现多次
                //      p[j - 1]和s[i]匹配的话,那么就需要匹配s[i - 1]和p[j] -> dp[i][j] = dp[i - 1][j]
                if (p.charAt(j - 1) == '*') {   // 为说明用到charAt的时候，需要-1, 因为i和j代表的是字符的长度，本身就比索引大着一个单位，因此去字符的时候需要减去
                    // 出现0次的情况
                    dp[i][j] = dp[i][j - 2];

                    // 出现多次的情况
                    if (match(s, p, i, j - 1)) {    // 先检验当前字符是否满足
                        dp[i][j] = dp[i][j] || dp[i - 1][j];    // 使用或者，只要两种情况满足一种就是真的
                    }
                } else {
                    // 匹配字符不等于*的时候 -> 匹配当前的字符，如果匹配的话，那么就是否是匹配就取决于前一个字符匹配的结果
                    // dp[i][j] = dp[i - 1][j - 1]
                    if (match(s, p, i, j)) {    // 先检验当前字符是否满足
                        dp[i][j] = dp[i - 1][j - 1];    // 如果当前的字符已经匹配的话，那么结果就取决去前一个字符匹配的结果
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        new IsMatch().isMatch_1("aa", "a");
    }
}
