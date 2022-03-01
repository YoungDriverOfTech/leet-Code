package bs;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {     // 注意，这里需要加入等号，如果需要插入的位置是1，但是left right目前是0，那么就需要在进行一次判断，是的left + 1， 所以加入等号
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
