package bs;

public class FindMin {

    // 例子 223 012
    // 上面的例子，旋转会把数组分成两个有序的子树组，并且后面数组的最后一位（即最大值） <= 前面数组的第一位（即最小值）
    // 取中位数和数组最后一位进行对比，如果 mid > right ---> mid > 右边数组的最大值 ---> 说明最小值肯定在mid的右边
    // 取中位数和数组最后一位进行对比，如果 mid < right ---> mid < 右边数组的最大值 ---> mid有可能就是最小值，所以end = mid; mid不要再-1
    // 如果mid == right， 说明还没找到最小值，此时right--， 因为right减少一个，并不影响找到最小值
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
