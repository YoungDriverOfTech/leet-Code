package doublePointor;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 题目并没有要求排序，所以不用排序也行
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { // 这里要求等于，因为等于的时候，也有可能这个元素是有效值，所以需要再计算一次
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}
