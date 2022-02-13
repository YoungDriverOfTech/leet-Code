package offer;

import java.util.HashMap;
import java.util.Map;

class ReversePairs {

    // 解析： https://www.bilibili.com/video/BV1fh411r7B8?from=search&seid=3799350436023790967&spm_id_from=333.337.0.0
    int count = 0;

    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return count;
    }

    private void merge(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {
        // 临时数组，用来存放排序过后的数字
        int[] tempArr = new int[right - left + 1];

        // 左右子数组的索引以及临时数组索引
        int indexOfSubArrLeft = left;
        int indexOfSubArrRight = mid + 1;
        int indexOfTempArr = 0;

        // 进行数组排序，并且统计逆数对
        while (indexOfSubArrLeft <= mid && indexOfSubArrRight <= right) {
            if (nums[indexOfSubArrLeft] <= nums[indexOfSubArrRight]) {
                tempArr[indexOfTempArr] = nums[indexOfSubArrLeft];
                indexOfTempArr++;
                indexOfSubArrLeft++;
            } else {
                tempArr[indexOfTempArr] = nums[indexOfSubArrRight];
                count += (mid - indexOfSubArrLeft + 1);
                indexOfTempArr++;
                indexOfSubArrRight++;
            }
        }

        // 把剩余的没有移动完的元素放入临时数组中
        for (; indexOfSubArrLeft <= mid; indexOfSubArrLeft++) {
            tempArr[indexOfTempArr] = nums[indexOfSubArrLeft];
            indexOfTempArr++;
        }

        for (; indexOfSubArrRight <= right; indexOfSubArrRight++) {
            tempArr[indexOfTempArr] = nums[indexOfSubArrRight];
            indexOfTempArr++;
        }

        // 覆盖原有数组的元素
        for (int i = 0; i < tempArr.length; i++) {
            nums[left + i] = tempArr[i];
        }
    }


    // second time
    public int reversePairs_1(int[] nums) {
        Map<String, Integer> result = new HashMap<>();
        result.put("result", 0);
        splitArr(nums, 0, nums.length - 1, result);
        return result.get("result");
    }

    private void splitArr(int[] nums, int left, int right, Map<String, Integer> result) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            splitArr(nums, left, mid, result);
            splitArr(nums, mid + 1, right, result);
            mergeArr(nums, left, mid, right, result);
        }
    }

    private void mergeArr(int[] nums, int left, int mid, int right, Map<String, Integer> result) {
        int[] tempArr = new int[right - left + 1];  // 临时数组，用来存储排序后的子树组
        int leftIndex = left;   // 把数组认为分成两段，来进行比较，并且统计逆序对个数
        int rightIndex = mid + 1;
        int tempIndex = 0;

        // 因为首先进来的是最小的数组单位，所以会进行排序，那么以后进来的数组已经是排序完的
        // mid - left + 1 这个公式呢就会起作用
        while (leftIndex <= mid && rightIndex <= right) {
            // 左边数组的元素小，不构成逆序对
            if (nums[leftIndex] <= nums[rightIndex]) {
                tempArr[tempIndex++] = nums[leftIndex++];
            } else {
                // 左边元素大，构成逆序对
                tempArr[tempIndex++] = nums[rightIndex++];
                int resultNo = result.get("result") + (mid - leftIndex + 1);
                result.put("result", resultNo);
            }
        }

        // 把剩下的没有统计完的元素，放进临时数组
        for (; leftIndex <= mid; leftIndex++) {
            tempArr[tempIndex++] = nums[leftIndex];
        }

        for (; rightIndex <= right; rightIndex++) {
            tempArr[tempIndex++] = nums[rightIndex];
        }

        // 替换原来的数组，将其变成有序的数组
        for (int i = 0; i < tempArr.length; i++) {
            nums[left + i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] param = new int[] {7,5,6,4};
        System.out.println(new ReversePairs().reversePairs(param));
    }
}