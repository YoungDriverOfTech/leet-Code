package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    // https://leetcode-cn.com/problems/implement-stack-using-queues/solution/wu-tu-guan-fang-tui-jian-ti-jie-yong-dui-63d4/
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    // 先把元素放到队列2，先后把队列1的元素，加到队列2后面，这是对列2就是一个栈，
    // 然后把队列1和2交换一下就行了，那么队列1就是栈。
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
