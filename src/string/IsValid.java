package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    // 借助栈来实现
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        // map for check stack
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // 因为栈满足先进后出的特点，所以正好可以满足括号的先后顺序
        // 只不过出栈的时候，需要借助map来进行判断
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.add(ch);
            }
        }

        return stack.isEmpty();
    }
}
