package top200;

import java.util.Arrays;

public class CoinChange {

    // https://leetcode-cn.com/problems/coin-change/solution/ling-qian-dui-huan-by-chen-wei-f-b6we/
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);//初始化dp数组, 这里不能初始化成0，因为下面的转移方程用的是min
        dp[0] = 0;//面额0只需要0个硬币兑换

        for (int i = 1; i <= amount; i++) {//循环面额
            for (int coin : coins) {//循环硬币数组
                if (i - coin >= 0) {//当面额大于硬币价值时
                    //dp[i - coin]： 当前面额i减当前硬币价值所需要的最少硬币
                    //dp[i] 可由 dp[i - coin] + 1 转换而来
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
