package offer;

public class CuttingRope2 {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (n == 4) {
            return 4;
        }

        long result = 1; //为什么要用long来定义呢？ 因为用int的话可能会超过int最大长度，所以先用long来定义
        while (n > 4) {
            result *= 3;
            result = result % 1000000007;
            n -= 3;
        }
        return (int)((n * result)  % 1000000007);
    }
}
