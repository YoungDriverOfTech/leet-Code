package order;

public class ReversePairs {
    private int count = 0;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return 0;
        }

        splitArr(nums, 0, len - 1);
        return count;
    }

    private void splitArr(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            splitArr(nums, left, mid);
            splitArr(nums, mid + 1, right);
            mergeArr(nums, left, mid, right);
        }
    }

    private void mergeArr(int[] nums, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];

        // 进行归并排序
        int tempIndex = 0;
        int i = left;
        int j = mid + 1;

        // 先统计，在排序， 不知道为什么保存和排序不能同时进行，就先记住把
        while (i <= mid && j <= right) {
            if ((long)nums[i] > 2 * (long) nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        // 排序数组
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            tempArr[tempIndex++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        // 把剩余的没有放入临时数组的元素放入
        while (i <= mid) {
            tempArr[tempIndex++] = nums[i++];
        }
        while (j <= right) {
            tempArr[tempIndex++] = nums[j++];
        }

        // 把临时数组里面的元素替换nums里面的元素
        for (int k = 0; k < tempArr.length; k++) {
            nums[left + k] = tempArr[k];
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{1,3,2,3,1}));
    }
}
