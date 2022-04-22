package hot100;

public class FindUnsortedSubarray {

    // https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int num1 = nums[i];
            if (num1 >= max) {
                max = num1;
            } else {
                end = i;
            }

            int num2 = nums[len - 1 - i];
            if (num2 <= min) {
                min = num2;
            } else {
                start = len - 1 -i;
            }
        }

        return end - start + 1;
    }
}
