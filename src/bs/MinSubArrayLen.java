package bs;

public class MinSubArrayLen {

    // my solution
    // 遍历数组，然后把每个元素想加，相加完成后，判断和target谁大谁小
    // 一旦sum >= target, 那么定义一个从0开始的指针，让sum依次减去做指针指向的值，来不停的减少最后result的值
    // 判断出最终result的值是多少
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
