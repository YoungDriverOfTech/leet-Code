package doublePointor;

import java.util.Stack;

public class ReverseVowels {
    public String reverseVowels(String s) {

        // 注意，这道题大写字符也算元音
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        // 把所有元音放入栈中
        for (char ch : chars) {
            if (ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ||
                    ch == 'A' || ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U') {
                stack.push(ch);
            }
        }

        // 然后拼接结果
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            if (ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ||
                    ch == 'A' || ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U') {
                result.append(stack.pop());
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
