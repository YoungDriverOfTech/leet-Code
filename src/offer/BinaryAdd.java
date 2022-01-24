package offer;

public class BinaryAdd {
    public int add(int a, int b) {

        int sum1 = Integer.MIN_VALUE; // 本位
        int sum2 = Integer.MIN_VALUE; // 进位

        // 没办法产生进位的时候就退出
        while (sum2 != 0) {
            sum1 = a ^ b;
            sum2 = (a & b) << 1;

            a = sum1;
            b = sum2;
        }

        return sum1;
    }
}
