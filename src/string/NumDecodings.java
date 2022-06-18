package string;

public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        // dp代表第i个字符有几种翻译方法，例如：第一个字符就只有1中翻译方法
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            char preChar = s.charAt(i - 1);
            char curChar = s.charAt(i);

            // 分为当前字符为0和不为0的情况
            // 如果当前字符0，切能与前面的字符组成一个合法数字，那么dp[i] = dp[i - 2]; 比如120 or 110
            // 但是需要注意一种特殊情况，比如10，20 这样只有两位的合法数字，那么翻译方法只有一种，特殊判断即可
            // 其余的情况都是0， 比如30， 140， 230，因为超过26就不可能被翻译了
            if (curChar == '0') {
                if (preChar == '1' || preChar == '2') {
                    if (i == 1) {
                        dp[i] = 1;
                    } else {
                        dp[i] = dp[i - 2];
                    }
                } else {
                    return 0;
                }
            } else {
                // 当前字符不等于0的话，就是青蛙跳台阶问题了
                if (preChar == '1' || (preChar == '2' && curChar <= '6')) {
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                } else {
                    // 只能被1种方法翻译，那么dp[i] = dp[i - 1]
                    dp[i] = dp[i - 1];
                }
            }

        }
        return dp[s.length() - 1];
    }

    // 如果当前数字可以当作一个数字来翻译，那么dp[i] == dp[i - 1]
    // 如果当前数字和前一个数字能当作一组数字来翻译，那么dp[i] == dp[i - 1] + dp[i - 2]
    // 并且我们需要让dp[0] == 1, 因为如果翻译到了第一个字符，明显是一种方法，那么dp[i] == dp[i - 1]时，我们需要让它正确
    public int numDecodings_1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            // 当作一个字符翻译
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // 和前一个字符组成一对儿翻译
            if (i > 1) {
                int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        new NumDecodings().numDecodings("2101");
    }
}
