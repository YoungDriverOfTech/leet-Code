package hot100;

public class FindUnsortedSubarray {

    // https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int num1 = nums[i];
            if (num1 >= max) {
                max = num1;
            } else {
                end = i;
            }

            int num2 = nums[len - 1 - i];
            if (num2 <= min) {
                min = num2;
            } else {
                start = len - 1 -i;
            }
        }

        return end - start + 1;
    }

    // 无序区间的右边界，实际上就是不满足从左到右递增的最后一个位置
    // 无序区间的左边界，实际上就是不满足从右到左递减的最前一个位置
    public int findUnsortedSubarray_1(int[] nums) {

        //从左往右找最后一个不满足单调递增的位置，它是无序区间的右边界
        int maxVal = Integer.MIN_VALUE;
        int to = -1;
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] < maxVal) {
                to = i;
            }
            maxVal = Math.max(nums[i], maxVal);
        }

        //从右往左找最前一个不满足单调递减的位置，它是无序区间的左边界
        int minVal = Integer.MAX_VALUE;
        int from = nums.length;
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] > minVal) {
                from = i;
            }
            minVal = Math.min(nums[i], minVal);
        }

        //如果完全有序
        if(to == -1) return 0;
        return to - from + 1;
    }
}
