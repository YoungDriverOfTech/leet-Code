package doublePointor;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 题目并没有要求排序，所以不用排序也行
        int left = 0;   // 最终结果的索引
        int right = nums.length;    // 遍历结果的索引

        // 如果左边的索引值等于val，那么就把右边的值贴到左边，然后右边索引-1，再继续判断left索引的值。
        // 如果不等于的话，那么就把left向右移
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
