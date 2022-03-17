package stack;

import java.util.Stack;

public class NextGreaterElements {
    // 做题模板
    // https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len * 2 - 1; i >= 0; i--) {
            int num = nums[i % len];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            result[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return result;
    }
}
