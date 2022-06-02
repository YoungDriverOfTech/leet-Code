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

    public int findDuplicate_1(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{7,9,7,4,2,8,7,7,1,5}));
    }
}
