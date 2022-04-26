package orderbyasc;

public class Search {
    // https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/java-xiang-xi-pou-xi-dai-ma-jian-ji-si-l-vm8u/
    public boolean search(int[] nums, int target) {
        // 根据题意，数组是经过旋转的，那么一旦计算出mid的话，那么mid一定是坐落于某一个非递减的区间，左或者右
        // 2,5,6,0,0,1,2 -> mid是0，那么左区间2,5,6,0不是非递减的，二分查找不能发生在这里
        //                  mid是0，那么右区间0,0,1,2是非递减的，二分查找应该发生在这里

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 因为题目要求元素可以重复，所以会出现这种恶心的case
            // [1,0,1,1,1]
            // 0
            // 我们需要保证区间的递增，如果做指针的值=mid的值！= target，那么我们可以指针把做指针往右边移动
            while (left <= mid && nums[left] == nums[mid]) {
                left++;
            }
            // 因为left指针移动会可能会产生边界问题，所以我们要返回最上层的while，再去check一次边界条件
            if (left > mid) {
                left = mid + 1;
                continue;
            }

            // 先判断那个区间是非递减的，然后移动双指针
            if (nums[left] <= nums[mid]) {  // 左区间非递减
                // 判断target是不是严格被包裹在【left，mid】中
                if (nums[left] <= target && target < nums[mid]) {   // 因为target和mid相等在上面的逻辑判断过了，所以这块不需要等号，如果不满足条件，那么target一定是在mid右边
                    right = mid - 1;
                } else {
                    left = mid + 1; // 根据22行，这里可以放心大胆的+1
                }
            } else {    // 右区间非递减
                // 判断target是不是严格被包裹在【mid，right】中
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1; // 根据22行，这里可以放心大胆的+1
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        new Search().search(new int[]{2,5,6,0,0,1,2}, 3);
    }
}
