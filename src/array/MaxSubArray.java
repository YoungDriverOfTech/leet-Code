package array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum <= 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            result = Math.max(currentSum, result);
        }

        return result;
    }
}
