package bs;

public class FindDuplicate {

    // https://leetcode.wang/leetcode-287-Find-the-Duplicate-Number.html
    public int findDuplicate(int[] nums) {
        // 因为范围是[1,n] 要把条件利用起来
        int n = nums.length - 1;
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // 统计这个数组中的元素，小于等于mid值的数量
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // 如果这个数量大于mid，说明mid前面的数，一定有重复的
            if (count > mid) {
                high = mid;     // 因为统计数字的时候num <= mid，把mid也算进去了，所以高位等于mid就行
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{7,9,7,4,2,8,7,7,1,5}));
    }
}
