package string;

import java.util.Stack;

public class Calculate {
    public int calculate(String s) {
        // 存储需要计算的数据，只有加减法。乘除法的话需要先计算完再扔进栈中
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        char preSign = '+'; // 上次的运算法
        int num = 0;    // 上次保存的数字

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果是数字的话，使用num记录下来
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');    // 注意这里，ch必须要减去0的字符，才能成为数字
            }

            // 如果不是数字的话，那么需要放进栈中（如果到了最后一个字符是数字的话，也进来进入下面的逻辑完成运算）
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                // 注意：这里的逻辑有点绕，碰到非字符的时候，处理的是上次记录的数据num，而不是这次（因为这次是运算字符）
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;
                }

                // 充值num和运算符,
                num = 0;
                preSign = ch;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        new Calculate().calculate("3*2-2");
    }
}
