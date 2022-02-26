package array;

public class FindMedianSortedArrays {

    // https://leetcode.wang/leetCode-4-Median-of-Two-Sorted-Arrays.html
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 这里的操作是为了抹除数组个数为奇偶的时候的差别
        // 比如 m=1 n=2 -> 中位数是2，那么left:2 right:2 -> 中位数=（left+right）/ 2
        //      m=2 n=2 -> 中位数是2，那么left:2 right:3 -> 中位数=（left+right）/ 2
        int left = (m + n + 1) / 2; // 代表第k个数
        int right = (m + n + 2) / 2;

        return ((double)getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) +
                (double)getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        // 如果查找到只剩下最后一个k了，那么直接返回
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 比较两个数组k/2个元素的大小
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return getKth(nums1, start1, end1, nums2, j + 1, end2,k - (j - start2 + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
