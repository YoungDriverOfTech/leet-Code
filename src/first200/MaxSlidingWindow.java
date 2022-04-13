package first200;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        // result array
        int[] resultArray = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();
        // form first circle
        queue.addLast(nums[0]);
        for (int i = 1; i < k; i++) {
            // keep queue in desc order
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {    // 注意，保持单调递减，要还最后一个元素 queue.peekLast()，而不是首个元素
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        resultArray[0] = queue.peekFirst();

        // form rest of circles
        for (int i = k; i < nums.length; i++) {
            // delete the first element of deque if necessary
            if (queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }

            // keep queue in desc order
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);

            // add element to result
            resultArray[i - k + 1] = queue.peekFirst();
        }

        return resultArray;
    }
}
