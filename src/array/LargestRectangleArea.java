package array;

import java.util.Stack;

public class LargestRectangleArea {

    // https://www.bilibili.com/video/BV1fi4y1d7YX
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {  // i < heights.length + 1
            newHeights[i] = heights[i - 1];     // 新数组从1开始，没有填充的默认是0
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < newHeights.length; i++) {
            // 新元素比栈顶元素的高度小的话，那么就要计算栈顶元素的面积了
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int stackPeakHeight = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;   // todo 需要在理解一下
                result = Math.max(result, stackPeakHeight * width);
            }
            stack.add(i);   // 栈中应该存放索引，用来计算宽度
        }
        return result;
    }

    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-7/
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
        System.out.println(new LargestRectangleArea().largestRectangleArea_1(new int[]{2,1,5,6,2,3}));
    }
}
