package offer;

public class NumWays {
//    设跳上 n级台阶有 f(n)种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1级或 2级台阶。
//    当为 1级台阶： 剩 n-1个台阶，此情况共有 f(n-1)种跳法；
//    当为 2级台阶： 剩 n-2个台阶，此情况共有 f(n-2)种跳法。
//    f(n)为以上两种情况之和，即 f(n)=f(n-1)+f(n-2)，以上递推性质为斐波那契数列。本题可转化为 求斐波那契数列第 n项的值
    public int numWays(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        // pre means how many methods to climb first step
        // cur means how many methods to climb second step
        int pre = 1, cur = 2, sum;
        for (int i = 3; i <= n; i++) {
            sum = (pre + cur) % 1000000007;
            pre = cur;
            cur = sum;
        }

        return cur;
    }
}
