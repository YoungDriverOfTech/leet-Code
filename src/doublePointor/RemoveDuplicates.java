package doublePointor;

import java.util.Arrays;

public class RemoveDuplicates {

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 最终结果的索引
        int left = 1;

        // 遍历数组的临时索引
        int right = 1;

        // 1，1，2，2，3
        // 现在left right都指向第二个1，right判断和right-1的元素相等不。 如果相等那么继续往后找right++
        // 如果不想等，那么就把当前的right的值贴到left上，并且left 也移动指针就可以了
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
