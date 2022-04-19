package hot100;

public class MaxProfit {
    // 动态规划
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
    // 不要关注冷冻期！不要关注冷冻期！不要关注冷冻期！
    // 只关注卖出的那一天！只关注卖出的那一天！只关注卖出的那一天！
    // 对于每i天，都有三种状态
    // 1. 不持股(当天没卖出，说明昨天也没买) -> dp[i][0]
    // 2. 持股 -> dp[i][1]
    // 3. 不持股(因为当天卖出了，所以手上没有了) -> dp[i][2]

    // 初始化
    // dp[0][0]=0; 本来就不持有，啥也没干
    // dp[0][1]=-1*prices[0]; 第0天只买入
    // dp[0][2]=0; 可以理解成第0天买入又卖出，那么第0天就是“不持股且当天卖出了”这个状态了，其收益为0，所以初始化为0是合理

    // 转移
    // dp[i][0] -> 两种情况：
    //              1.昨天卖了;
    //              2.昨天和今天一样不持股也没卖， 那么今天最大的收益就是
    //              dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][0])
    //
    // dp[i][1] -> 两种情况：
    //              1.昨天持股，今天继承;
    //              2.昨天不持股，今天买入了，但是昨天不能是卖出的那天，因为有cooldown
    //              dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
    //
    // dp[i][2] -> i天不持股且当天卖出了，这种就简单了，那就是说昨天我一定是持股的
    //              dp[i][2]=dp[i-1][1]+prices[i]
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;

        // 1. 不持股(当天没卖出，说明昨天也没买) -> dp[i][0]
        // 2. 持股 -> dp[i][1]
        // 3. 不持股(因为当天卖出了，所以手上没有了) -> dp[i][2]
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        // 自后一天一定要不持有股票的状态才会有最大值，所以一定是状态0和2中间的较大值
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}
