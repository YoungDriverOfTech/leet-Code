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


    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
