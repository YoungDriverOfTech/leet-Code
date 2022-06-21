package offer;

import java.util.*;

public class MaxSlidingWindow {

    // my solution
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


    // better solution
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len - k + 1];

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.getLast() < num) {
                stack.removeLast();
            }
            stack.addLast(num);
        }

        int index = 0;
        res[index++] = stack.getFirst();

        for (int i = k; i < len; i++) {

            if (nums[i - k] == stack.getFirst()) {
                stack.removeFirst();
            }

            int num = nums[i];
            while (!stack.isEmpty() && stack.getLast() < num) {
                stack.removeLast();
            }
            stack.addLast(num);
            res[index++] = stack.getFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow_1(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
}
