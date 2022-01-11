package offer;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
        // my solution
//    private LinkedList<Integer> stackIn;
//    private LinkedList<Integer> stackOut;

//    public CQueue() {
//        stackIn = new LinkedList<>();
//        stackOut = new LinkedList<>();
//    }
//
//    public void appendTail(int value) {
//        stackIn.add(value); // notice, do not use push method, it will change insert order and effect final result
//    }
//
//    public int deleteHead() {
//
//        if (!stackOut.isEmpty()) {
//            return stackOut.remove();
//        }
//
//        if (!stackIn.isEmpty()) {
//            stackOut.add(stackIn.remove());
//        }
//
//        return stackOut.isEmpty() ? -1 : stackOut.remove();
//    }

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }


    public static void main(String[] args) {

        // case 1
        CQueue cQueue1 = new CQueue();
        cQueue1.appendTail(3);
        System.out.println(cQueue1.deleteHead());
        System.out.println(cQueue1.deleteHead());


        // case 2
        CQueue cQueue2 = new CQueue();
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(5);
        cQueue2.appendTail(2);
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
    }

}