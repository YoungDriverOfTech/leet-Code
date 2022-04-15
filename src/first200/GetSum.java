package first200;

public class GetSum {
    // 位运算中，异或操作获得无进位的运算结果
    // 与运算 << 1 来获得进位
    // https://leetcode-cn.com/problems/sum-of-two-integers/solution/liang-zheng-shu-zhi-he-by-leetcode-solut-c1s3/
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
