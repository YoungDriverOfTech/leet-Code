package offer;

public class MaxSubArray {


    // 从头到尾遍历数组，并把每个元素相加，如果和小于0了，直接舍弃，重新开始相加运算
    // 如果和>0，那么继续累加元素。
    // 用一个变量实时的保存最大值
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            if (result < currentSum) {
                result = currentSum;
            }
        }

        return result;
    }

    public int maxSubArray_1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(num, num + currentSum);
            result = Math.max(result, currentSum);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
