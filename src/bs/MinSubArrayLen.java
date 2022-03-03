package bs;

public class MinSubArrayLen {

    // my solution
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length ==1) {
            if (nums[0] == target) {
                return 1;
            } else {
                return 0;
            }

        }
        int currentSum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= target && left <= i) {
                result = Math.min(result, i - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
