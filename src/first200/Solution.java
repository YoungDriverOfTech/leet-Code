package first200;

import java.util.Random;

// https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode-solution-og5u/
public class Solution {

    private int[] nums;
    private int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, this.nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, this.nums.length);
        return this.nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length - i);    // 注意，这里是-i，不是-1
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
