package offer;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] k = new int[32]; // 这个树组用来装每个int，每一位是1的个数的和
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                k[j] += (num >> j & 1) == 1 ? 1 : 0; // 先判断最右位是不是1，1的话就进行累加。然后右移动1位，继续判断，累加...
            }
        }

        int res = 0;
        for (int i = 31; i >= 0; i--) { // 为什么从31开始，因为上面的循环是从最右位开始累加的。
            res = res << 1;
            if (k[i] % 3 == 1) {
                res = (res ^ 1);
            }
        }
        return res;
    }

    public int singleNumber_1(int[] nums) {
        int[] dp = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    dp[i] += 1;
                }
            }
        }

        int result = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            int num = dp[i];
            result <<= 1;   // 注意 这个位移动应该写到 if判断的前面，
            if (num % 3 == 1) {
                result ^= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new SingleNumber().singleNumber(new int[]{3, 4, 3, 3});
    }
}
