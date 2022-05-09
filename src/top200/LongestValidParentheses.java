package top200;

import java.util.Stack;

public class LongestValidParentheses {
    // https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }

        // 在栈中存放索引，然后遇到做括号直接压入索引，右括号弹出栈，然后判断stack是不是空，如果是空
        // 那么就把右括号索引压入栈中，如果不为空，那么就去当前元素索引和栈顶元素索引的差，来判断最大值
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (ch == '(') {
                stack.push(i);  // 弹出是因为括号是两个一对，需要先弹出做括号，才能计算长度
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    count = Math.max(count, i - stack.peek());
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
