package offer;

public class MyPow {

    // explanation: https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMui(x, N) : 1.0 / quickMui(x, -N);
    }

    private double quickMui(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double result = quickMui(x, n / 2);
        return n % 2 == 0 ? result * result : result * result * x;
    }

}
