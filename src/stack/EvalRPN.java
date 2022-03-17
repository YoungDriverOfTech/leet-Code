package stack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        // 遇到数字直接压站，遇到运算符，把栈顶的两个元素拿出来，做运算，然后在压入栈顶
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int num1 = Integer.parseInt(stack.pop());
                    int num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 + num2));
                    break;
                }
                case "-" -> {
                    int num1 = Integer.parseInt(stack.pop());
                    int num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num2 - num1));    // 减法注意顺序

                    break;
                }
                case "*" -> {
                    int num1 = Integer.parseInt(stack.pop());
                    int num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num1 * num2));
                    break;
                }
                case "/" -> {
                    int num1 = Integer.parseInt(stack.pop());
                    int num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num2 / num1));    // 除法注意顺序

                    break;
                }
                default -> stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
