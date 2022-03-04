package bs;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    private int[] indexes;  // 用来存放nums的索引，进行比较的时候，应该比较nums的值，但是操作排序，和归并的时候，应该使用这个数组
    private int[] count;    // 用来统计每个位置上面的逆序对个数

    // 类似与求逆序对，只不过这次是求的，当前元素后面的逆序对
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 空数组的话返回空的list就行了
        int len = nums.length;
        if (len == 0) {
            return result;
        }

        // indexes用来存储数组的索引
        indexes = new int[len];
        count = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }

        // 非空数组先对数组进行分割，然后在进行merge
        splitArr(nums, 0, len - 1);

        // 把统计号的值放入result中
        for (int j : count) {
            result.add(j);
        }
        return result;
    }

    private void splitArr(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start < end) {  // 这里是if不是while
            splitArr(nums, start, mid);
            splitArr(nums, mid + 1, end);
            mergeArr(nums, start, mid, end);
        }
    }

    private void mergeArr(int[] nums, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int[] temp = new int[end - start + 1];    // 用来存储临时索引的数组
        int tempIndex = 0;

        // 归并排序判断
        // 这次的题目需要用倒序来排序，然后左边的元素一旦大于右边的，那么就需要计算左边这个元素对应右边的逆序对，因为是倒序的所以使用end - j + 1
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[indexes[leftIndex]] <= nums[indexes[rightIndex]]) {
                temp[tempIndex++] = indexes[rightIndex++];
            } else {
                count[indexes[leftIndex]] += end - rightIndex + 1;
                temp[tempIndex++] = indexes[leftIndex++];
            }
        }

        // 把剩下没放完的数组放入temp数组中
        while (leftIndex <= mid) {
            temp[tempIndex++] = indexes[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = indexes[rightIndex++];
        }

        // 把排序号的临时数组的值，存入到indexes中
        for (int i = 0; i < temp.length; i++) {
            indexes[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {    // 25  16
        List<Integer> integers = new CountSmaller().countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(integers);
    }
}
