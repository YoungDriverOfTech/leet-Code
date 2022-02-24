package array;

public class Merge {

    // https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;
        int cur = 0;

        int[] sorted = new int[m + n];
        while (p < m || q < n) {
            if (p == m) {
                cur = nums2[q++];
            } else if (q == n) {
                cur = nums1[p++];
            } else if (nums1[p] <= nums2[q]) {
                cur = nums1[p++];
            } else {
                cur = nums2[q++];
            }

            sorted[p + q - 1] = cur;
        }

        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        new Merge().merge(nums1, m, nums2, n);
    }
}
