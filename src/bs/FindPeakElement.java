package bs;

public class FindPeakElement {

    // https://leetcode-cn.com/problems/find-peak-element/solution/er-fen-cha-zhao-zui-jian-jie-yi-dong-de-cvn1f/
    // 找到中间位置，判断中间位置mid 和mid + 1的值 (注意，题目说开头和结尾趋于无穷小，所以单调递减的时候nums[left]就是峰值，繁殖nums[right]就是峰值)
    // 如果 mid > mid+1  --> 说明峰值在mid左边，那么缩小右边界 right = mid
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {    // 并不一定是有等号，下面就+-1，现在的情况是递减的，有可能mid就是首元素，就是mid就是峰值，所以不能mid - 1了
                right = mid;
            } else {
                left = mid + 1;  // 这里+1 表明，如果mid 和mid + 1是相等的话，那么峰值一定是出现在mid+ 1之后
            }
        }
        return right;
    }
}
