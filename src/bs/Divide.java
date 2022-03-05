package bs;

public class Divide {

/**    举个例子：11 除以 3 。
    首先11比3大，结果至少是1， 然后我让3翻倍，就是6，发现11比3翻倍后还要大，那么结果就至少是2了，那我让这个6再翻倍，得12，11不比12大，
    吓死我了，差点让就让刚才的最小解2也翻倍得到4了。但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数，
    这个数是多少呢？我让11减去刚才最后一次的结果6，剩下5，我们计算5是3的几倍，也就是除法

    100/3
    100>3 100>6 100>12 100>24 100>48 100>96 100<192 ---- 使用了 2^5 = 32 个3，还剩 100 - 96 = 4 需要被除
    4>3 4<6                                         ---- 使用了 2^0 = 1  个3，还剩 4   - 3  = 1 需要被除
    1<3                                             ---- 被除数小于除数，递归结束，总计使用了 33 个 3

*/
    public int divide(int dividend, int divisor) {
        // 处理特殊情况
        if (dividend == 0) {
            return 0;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;   // 子要比最小值大，那么返回相反数即可，如果等于最小值，那么就返回最大值
            }
            return Integer.MAX_VALUE;
        }

        // 因为可能有越界的问题，所以使用长整形来存被除数和除数
        long a = (long) dividend;
        long b = (long) divisor;

        // 将a b都转换成正数来进行计算，那么就先保存一下他们结果的正负号
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b >0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;

        // 计算除法
        long result = div(a, b);
        if (sign > 0) {
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
        }
        return (int)(sign * result);
    }

    private long div(long a, long b) {
        if (a < b) {
            return 0;
        }

        long count = 1;
        long tb = b;
        while ((tb + tb) < a) {
            count = count + count;
            tb = tb + tb;
        }

        return count + div(a - tb, b);
    }
}
