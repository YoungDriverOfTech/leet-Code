package top200;

public class Rob {
    // https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
    // time  O(n)
    // space O(1)
    public int rob(int[] nums) {
        // dp[i] 偷某房子的最大金额
        // 首先考虑最简单的情况。如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，
        // 只能偷窃其中的一间房屋，因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额。
        // 可根据上面得出初始条件
        // dp[1] = Math.max(nums[0], nums[1]);

        // 再分析后续条件
        // 如果偷第k件房子，那么可以选择偷或者不偷，
        // 1偷： dp[k] = dp[k - 2] + num[k]
        // 2不偷： dp[k] = dp[k - 1]
        // 取两者中的最大值即可

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int num = nums[i];
            dp[i] = Math.max(dp[i - 2] + num, dp[i - 1]);
        }

        return dp[length - 1];
    }
}
