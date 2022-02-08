package offer;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateStackSequences {

    // explanation: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();   // 注意，stack不能用linkedList做实现

        int i = 0;  // 出栈栈顶的索引
        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[i]) { // !stack.isEmpty() 这个条件不能省略，否则peek方法会报错
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
