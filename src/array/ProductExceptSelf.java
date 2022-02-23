package array;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] resultArr = new int[nums.length];

        // first half
        int temp1 = 1;
        resultArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            temp1 *= nums[i - 1];
            resultArr[i] = temp1;
        }

        // last half
        int temp2 = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp2 *= nums[i + 1];   // 注意，这里应该写成i+1，不是nums.length - 1,如果写成这样，那么数值就不会变了
            resultArr[i] *= temp2;
        }

        return resultArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
