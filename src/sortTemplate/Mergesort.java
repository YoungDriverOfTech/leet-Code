package sortTemplate;

import java.util.Arrays;

public class Mergesort {


    // 类似与求逆序对，只不过这次是求的，当前元素后面的逆序对
    public void mergeSort(int[] nums) {

        // 空数组的话返回空的list就行了
        int len = nums.length;

        // 非空数组先对数组进行分割，然后在进行merge
        sort(nums, 0, len - 1);
    }

    private void sort(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start < end) {  // 这里是if不是while
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
        }

        int leftIndex = start;
        int rightIndex = mid + 1;
        int[] temp = new int[end - start + 1];    // 用来存储临时索引的数组
        int tempIndex = 0;

        // 归并排序判断
        // 这次的题目需要用倒序来排序，然后左边的元素一旦大于右边的，那么就需要计算左边这个元素对应右边的逆序对，因为是倒序的所以使用end - j + 1
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }

        // 把剩下没放完的数组放入temp数组中
        while (leftIndex <= mid) {
            temp[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = nums[rightIndex++];
        }

        // 把排序号的临时数组的值，存入到indexes中
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Mergesort obj = new Mergesort();

        int[] param = new int[]{3,5,1,2,5,6,3,8};
        System.out.println(Arrays.toString(param));
        obj.mergeSort(param);
        System.out.println(Arrays.toString(param));
    }
}
