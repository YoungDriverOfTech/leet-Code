package top200;

public class IsPowerOfThree {
    // https://leetcode-cn.com/problems/power-of-three/solution/gong-shui-san-xie-yi-ti-san-jie-shu-xue-8oiip/
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree_1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
