package offer;

public class TranslateNumber {

    // explanation: https://www.bilibili.com/video/BV1K341117Pm?from=search&seid=17308081126989119841&spm_id_from=333.337.0.0
    public int translateNum(int num) {
        String s = String.valueOf(num);

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '5')) { // 注意，这里的条件是前面一个，和后面两个，不要搞混了。
                if (i == 1) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[s.length() - 1];
    }

    public int translateNum_2(int num) {
        char[] chars = String.valueOf(num).toCharArray();

        // 注意 这里面的长度不应该num，应该把num转换成字符数组，把字符数组长度放入初始化
        int[] dp = new int[chars.length]; // store possibly translation count
        dp[0] = 1;

        for (int i = 1; i < chars.length; i++) {
            char preCh = chars[i - 1];
            char curCh = chars[i];

            // fullfill 2 translations condition
            if ((preCh == '1') || (preCh == '2' && curCh <= '5')) {
                if (i == 1) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        // 不应该return dp[num - 1]; 应该return dp[chars.length - 1];
        return dp[num - 1];
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNumber().translateNum(25));
    }
}
