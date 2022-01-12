package offer;

public class TranslateNumber {

    // explanation: https://www.bilibili.com/video/BV1K341117Pm?from=search&seid=17308081126989119841&spm_id_from=333.337.0.0
    public int translateNum(int num) {
        String s = String.valueOf(num);

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '5')) {
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

    public static void main(String[] args) {
        System.out.println(new TranslateNumber().translateNum(25));
    }
}
