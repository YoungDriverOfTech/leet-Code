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
}
