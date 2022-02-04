package offer;

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

    public static void main(String[] args) {
        int[] param = new int[] {7,5,6,4};
        System.out.println(new ReversePairs().reversePairs(param));
    }
}