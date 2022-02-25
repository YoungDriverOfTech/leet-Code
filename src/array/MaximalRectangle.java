package array;

import java.util.Stack;

public class MaximalRectangle {
    // https://leetcode.wang/leetCode-85-Maximal-Rectangle.html
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0; // 注意，这里不要写成0
                }
            }
            // 计算出最大面积
            maxArea = Math.max(maxArea, largestRectangleArea_1(heights));
        }
        return maxArea;
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

    public static void main(String[] args) {
        new MaximalRectangle().maximalRectangle(new char[][]{{'1','0'}});
    }
}
