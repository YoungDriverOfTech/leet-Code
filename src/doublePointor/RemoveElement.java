package doublePointor;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 题目并没有要求排序，所以不用排序也行
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
