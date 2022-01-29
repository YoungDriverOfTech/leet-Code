package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int currentMaxValue = Integer.MIN_VALUE;

            int j = i;
            int endPoint = j + k;
            for ( ;j < endPoint && j < nums.length; j++) {
                currentMaxValue = Math.max(currentMaxValue, nums[j]);
            }
            result.add(currentMaxValue);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
