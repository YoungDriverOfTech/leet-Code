package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            // 把所有的非] 字符，全部丢进栈中
            if (ch != ']') {
                stack.push(ch);
            } else {
                // 1. 把所有的字符都取出来
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                // 2. 去掉[字符
                String subStr = sb.toString();
                stack.pop();

                // 3. 拿到数字，并且遍历字符串
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.parseInt(sb.toString());

                while (count > 0) {
                    for(char newChar : subStr.toCharArray()) {
                        stack.push(newChar);
                    }
                    count--;
                }
            }
        }

        // 输出所有的字符
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty()) {
            retv.insert(0, stack.pop());
        }
        return retv.toString();
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("3[a2[c]]");
    }
}
