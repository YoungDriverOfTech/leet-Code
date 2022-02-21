package array;

public class FindMedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 1.0;
    }


    // my solution
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        for (; i < m && j < n;) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[index] = nums1[i];
                i++;
            } else {
                mergedArray[index] = nums2[j];
                j++;
            }
            index++;
        }

        // merge the rest elements
        for (; i < m; i++) {
            mergedArray[index] = nums1[i];
            index++;
        }

        for (; j < n; j++) {
            mergedArray[index] = nums2[j];
            index++;
        }

        // find median
        int midIndex = (mergedArray.length / 2) - 1;    // length need -1
        if (mergedArray.length % 2 != 0) {
            return (double) mergedArray[midIndex + 1];  // eg 1,2,3
        } else {
            double result;
            result = (double)((mergedArray[midIndex] + mergedArray[midIndex + 1]) / 2.0);   // eg 1,2,3,4
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
