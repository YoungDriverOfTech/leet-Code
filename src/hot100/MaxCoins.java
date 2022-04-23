package hot100;

public class MaxCoins {
    // https://leetcode-cn.com/problems/burst-balloons/solution/java-si-lu-qing-xi-dai-ma-jian-ji-by-ven-f8qx/
    // https://leetcode-cn.com/problems/burst-balloons/solution/312-chuo-qi-qiu-dong-tai-gui-hua-by-chen-1sre/
    public int maxCoins(int[] nums) {
        // 因为左右边界超过以后需要乘以1，所以做一个新数组来满足约束条件
        int len = nums.length;
        int[] res = new int[len + 2];

        // 初始化新数组
        for (int i = 0; i < len + 2; i++) {
            if (i == 0 || i == len + 1) {
                res[i] = 1;
            } else {
                res[i] = nums[i - 1];
            }
        }

        // i从右往左，j从左往右，k是夹在ij中间的数
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len + 1; i >= 0; i--) {
            for (int j = i + 2; j < len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = dp[i][k] + dp[k][j];
                    sum += res[i] * res[k] * res[j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][len + 1];
    }
}
