package offer;

public class DicesProbability {

    // explanation: https://www.bilibili.com/video/BV1Ez4y1Q7SM?spm_id_from=333.1007.top_right_bar_window_history.content.click
    public double[] dicesProbability(int n) {

        // dp 表示的是n个骰子，仍在地上，朝上一面的点数和的个数总和
        // n代表有多少个骰子，6*n代表点数和的最大值。比如1个骰子，最大值就是6。2个骰子最大值就是12
        // dp[2][6] 这个代表的就是仍2个骰子，朝上的面的点数和为6，一共有多少种情况
        int [][] dp = new int[n][6 * n];

        // 存储答案的树组，这个树组存储着点数和出现的概率
        // 比如2个骰子，出现点数和为2的概率，出现点数和为2的情况只有一种，两个骰子各为1，总的情况呢有6的n次方种
        // 那么2对应的概率就是1/6*2 = 1/36
        // 两个骰子的点数和范围是2-12，一共11个数，退出来的长度是6n - n + 1 = 5n + 1
        double[] ans = new double[5 * n + 1];

        // 初始化初始值，即第一个骰子，出现1-6点数可能出现的情况，因为只有一个骰子，所以点数出现的次数只能是1
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {   // 遍历每个骰子
            for (int j = i; j < 6 * n; j++) {   // 遍历点数和，因为点数和的范围是n-6n,所以有几个骰子起始位置就是几
                for (int k = 1; k <= 6; k++) {
                    // 转移方程，假如要求第三个骰子点数和为8的情况，现在一个骰子能出现的值是1-6，所以前两枚骰子的值需要为7-2，才能满足和为8
                    // 的情况。那么我们只需要把前两枚骰子和为7-2的情况数量，累加起来，就能找到第3个骰子和为8的情况数量
                    // dp[3][8] = dp[2][7] + dp[2][6] + dp[2][5] + dp[2][4] + dp[2][3] + dp[2][2]
                    if (i - 1 >= 0 && j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        // 一共有多少种情况，一个骰子6种，两个骰子(1,1) (1,2)...(1,6) (2,1)...(6,6) 共计36种,6的2次方
        double all = Math.pow(6.0, n);
        // 计算出概率，存进答案树组
        for (int i = 0; i < ans.length; i++) {
            // 第n个骰子的最小值是从n开始，又因为树组是0基的，所以[n - 1 + i]
            ans[i] = dp[n - 1][n - 1 + i] / all;
        }

        return ans;
    }

    public double[] dicesProbability_1(int n) {
        // dp[][] 【骰子数量】【面朝上点数和】=【出现的情况数量】
        int[][] dp = new int[n][6 * n]; // 骰子最大值6，有n个骰子，最大值就是6*n

        // 初始化一个骰子的情况
        for (int i = 0; i < 6; i++) {   // i < 6, 不能是i < n, 因为我们需要初始化6个面的情况
            dp[0][i] = 1;
        }

        // 例子：假如两个骰子，那么面朝上的点数是2-12. 就等于6n-n + 1 = 5n + 1
        double[] result = new double[5 * n + 1];

        // 转移方程
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i - 1 >= 0 && j - k >= 0){
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        // 算出总数来求概率
        double all = Math.pow(6.0, n);
        for (int i = 0; i < result.length; i++) {
            result[i] = dp[n -1][n - 1 + i] / all;
        }

        return result;
    }

    public static void main(String[] args) {
        new DicesProbability().dicesProbability(1);
    }
}
