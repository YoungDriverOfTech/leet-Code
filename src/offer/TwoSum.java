package offer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int result = nums[start] + nums[end];
            if(result < target) {
                start++;
            }
            else if(result > target) {
                end--;
            }
            else {
                return new int[] { nums[start], nums[end] };
            }
        }
        return new int[0];
    }



    public static void main(String[] args) {
        int[] param = {2, 7, 11, 5};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(param, target)));
    }
}
