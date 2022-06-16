package array;

public class NextPermutation {
    // https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
    // time O(n)
    // space O(1)
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        int j = len - 1;
        int k = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }//从后往前找

        if (i >= 0) {//不是最后一个序列
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, j, len - 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public void reverse(int[] nums, int a, int b) {
        while (a < b) {
            swap(nums, a++, b--);
        }
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2});
    }
}
