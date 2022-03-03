package bs;

public class SearchRange {

    // https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/tu-jie-er-fen-zui-qing-xi-yi-dong-de-jia-ddvc/
    public int[] searchRange(int[] nums, int target) {
        // 米不+1米大等，mid给right剩余增
        // 米要+1米小等，mid给left剩余降
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        // 此题分别计算目标元素的开始位置和结果位置
        // 先计算开始位置
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {  // 只要中间元素大于等于target，right就会一直往中间移动，直到中间元素小于target，那么这是end就是首个值为target的索引
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (target != nums[end]) {
            return new int[]{-1, -1};
        }

        // 计算结束位置
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {  // 只要中间元素小于等于target,那么left指针就会一直往中间移动，直到中间元素大于target，那么left指针就是最后一个值为target的索引
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{end, left};
    }


    // 二分模板1
    // 当把区间划分成[left, mid], [mid + 1, right]时，计算mid的时候不需要+1，
    // 如果更新区间的时候，发现右边界需要更新成mid，就用这个模板

    // 米不+1米大等，mid给right剩余增
/*
    int bsearch_1(int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {   // 判断的时候永远加上等号
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
*/

    // 二分模板1
    // 当把区间划分成[left, mid - 1], [mid, right]时，计算mid的时候需要+1，
    // 如果更新区间的时候，发现左边界需要更新成mid，就用这个模板

    // 米要+1米小等，mid给left剩余降
/*    int bsearch_2(int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {   // 判断的时候永远加上等号
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
*/

}
