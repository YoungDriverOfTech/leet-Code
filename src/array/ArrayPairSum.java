package array;

import java.util.Arrays;

public class ArrayPairSum {

    // 题目要求从两个数中挑一个较小的，然后求这些数的和的最大值
    // 我们只需要排序一次，然后隔一个取一个数字就行了
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
