package offer;

import java.util.Stack;

class MinStack {

    private Stack<Integer> A, B;

    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        // notice: must use >=, because parameters probably be these [0, 1, 0], and if the last one [0] isn't added into B stack
        // there will be a error when min method is called after pop method called
        if (B.isEmpty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        // case 1
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());  // -3
        minStack.pop();
        System.out.println(minStack.top());  // 0
        System.out.println(minStack.min());  // -2

    }
}

