package bs;

public class Search {
    // 给定数组取出中位数，那么一定是一半有序，一般无序
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // 如果左半边有序，并且目标值在左半边区间内，那么就在左半区间内找，否则在右半区间内找
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {   // 注意大于小于号，要确保所有的元素都能包括进来
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 如果在右半有序，并且目标值落在右半区间，那么就在右半区间找，否则就在左半区间找
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Search().search(new int[]{1,3}, 2);
    }
}
