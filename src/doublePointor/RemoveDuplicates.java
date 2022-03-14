package doublePointor;

import java.util.Arrays;

public class RemoveDuplicates {

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 1;
        int right = 1;

        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }


    public int removeDuplicates_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                nums[right++] = 101;
            } else {
                left = right++;
            }
        }

        Arrays.sort(nums);
        int k = 0;
        for (int num : nums) {
            if (num != 101) {
                k++;
            }
        }
        return k;
    }
}
