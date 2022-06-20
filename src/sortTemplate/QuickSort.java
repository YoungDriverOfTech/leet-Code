package sortTemplate;

import java.util.Arrays;

public class QuickSort{

    public void sort(int[] sourceArray) throws Exception {
        quickSort(sourceArray, 0, sourceArray.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        // 如果只剩下一个元素，那么就不需要排序了
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // 挑选最右边的元素作为基准值
        int pivot = arr[right];

        // 从左到右的遍历整个数组，日过比基准值小，那么就和storeIndex交换
        int storeIndex = left;
        for (int i = left; i < right; i++) {    // 这里i < right 不应该有等于号，因为最右边的元素被当成比较标准元素，最后会进行交换，所以不能写等号
            if (arr[i] <= pivot) {
                swap(arr, i, storeIndex);
                storeIndex += 1;    // 这个的左边，一直存放的小于pivot的值，所以一旦发生了交换，这个索引就需要往右移动
            }
        }

        // 最后storeIndex存放的是大于pivot的值，所以要和pivotIndex进行再一次交换
        // 因为一开始的时候，把pivot丢到了最右边，所以和最右边交换即可
        swap(arr, storeIndex, right);

        return storeIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        QuickSort quickSort = new QuickSort();
        int[] param = new int[]{3,2,1,5,6,4};
        System.out.println(Arrays.toString(param));
        quickSort.sort(param);
        System.out.println(Arrays.toString(param));
    }
}
