package orderbyasc;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        // 统计数组中每个数字的每一位一共有多少个1
        int[] arrOfNum1 = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                if (((num >> j) & 1) == 1) {
                    arrOfNum1[j]++;
                }
            }
        }

        // 现在arrOfNum1是倒着的统计每个数字每位上有多少个1的数组
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            if (arrOfNum1[i] % 3 != 0) {
                result ^= 1;
            }
        }

        return result;
    }
}
