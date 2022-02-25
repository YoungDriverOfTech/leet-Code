package array;

import java.util.Stack;

public class MaximalRectangle {
    // https://leetcode.wang/leetCode-85-Maximal-Rectangle.html
    public int maximalRectangle(char[][] matrix) {


    }

    public int largestRectangleArea_1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int peekHeight = heights[stack.pop()];
                    int leftMinIndex = stack.isEmpty() ? -1 : stack.peek();
                    int width = i - 1 - leftMinIndex;
                    maxArea = Math.max(maxArea, peekHeight * width);
                }
                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            int peekHeight = heights[stack.pop()];
            int leftMinIndex = stack.isEmpty() ? -1 : stack.peek();
            int width = heights.length - 1 - leftMinIndex;
            maxArea = Math.max(maxArea, peekHeight * width);
        }

        return maxArea;
    }

}
