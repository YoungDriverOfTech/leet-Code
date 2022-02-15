package string;

import java.util.Stack;

public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {

        if (s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.add(ch);
                sb.append(ch);
            } else if (ch == ')') {
                // 不包含的话，就不用加入到sb中
                if (stack.contains('(')) {
                    stack.pop();
                    sb.append(ch);
                }
            } else {
                // 普通字符加入到sb中
                sb.append(ch);
            }
        }

        // 把多余的(删除掉
        int endIndex = sb.length() - 1;
        while (!stack.isEmpty()) {
            if (sb.charAt(endIndex) == '(') {
                sb.deleteCharAt(endIndex);
                stack.pop();
            }
            endIndex--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new MinRemoveToMakeValid().minRemoveToMakeValid("lee(t(c)o)de)");
    }
}
