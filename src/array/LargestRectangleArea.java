package array;

import java.util.Stack;

public class LargestRectangleArea {

    // https://www.bilibili.com/video/BV1fi4y1d7YX
    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-7/
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

    // todo 没有手敲， 需要重新敲一边
    public int largestRectangleArea_1(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        while (p < heights.length) {
            //栈空入栈
            if (stack.isEmpty()) {
                stack.push(p);
                p++;
            } else {
                int top = stack.peek();
                //当前高度大于栈顶，入栈
                if (heights[p] >= heights[top]) {
                    stack.push(p);
                    p++;
                } else {
                    //保存栈顶高度
                    int height = heights[stack.pop()];
                    //左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                    //右边第一个小于当前柱子的下标
                    int RightLessMin = p;
                    //计算面积
                    int area = (RightLessMin - leftLessMin - 1) * height;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        while (!stack.isEmpty()) {
            //保存栈顶高度
            int height = heights[stack.pop()];
            //左边第一个小于当前柱子的下标
            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
            //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
            int RightLessMin = heights.length;
            int area = (RightLessMin - leftLessMin - 1) * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }



    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
