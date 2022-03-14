package doublePointor;

public class SortColors {
    // https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
    public void sortColors(int[] nums) {
        // 双指针法, 0 1 2 应该被放进如下的区间
        // [0, p0) -> 0
        // [p0, i) -> 1
        // (i, p2) -> 2
        int len = nums.length;
        if (len < 2) {
            return;
        }

        int p0 = 0;
        int i = 0;
        int p2 = len - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                i++;
                p0++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                // i++; 注意：这里不需要i++,因为交换到i上的那个元素，还不确定是0 还是1，所以要进行下一次循环来判断
                p2--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
