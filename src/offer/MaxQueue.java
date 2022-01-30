package offer;

import java.util.LinkedList;

public class MaxQueue {

    private LinkedList<Integer> dataQueue;
    private LinkedList<Integer> maxValueQueue;

    public MaxQueue() {
        dataQueue = new LinkedList<>();
        maxValueQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxValueQueue.isEmpty()) {
            return -1;
        }
        return maxValueQueue.getFirst();
    }

    // keep the biggest value in the first position of maxValueQueue
    public void push_back(int value) {
        dataQueue.add(value);
        // we should keep the biggest value in the last position of maxValueQueue, prove
        // if we put [5, 5, 6], 6 will be placed into maxValueQueue and there is only one element, if pop twice, no effect
        // to maxValueQueue. one more pop will remove the biggest element

        // if we put [6, 5, 5], the maxValueQueue will be like this [6, 5, 5], if pop twice, there is only 6 left, the biggest value
        // is 6, one more time to pop will remove 6.
        while (!maxValueQueue.isEmpty() && maxValueQueue.getLast() < value) {
            maxValueQueue.removeLast();
        }
        maxValueQueue.addLast(value);
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) {
            return -1;
        }

        Integer frontElement = dataQueue.removeFirst();
        if (frontElement.equals(maxValueQueue.getFirst())) {
            maxValueQueue.removeFirst();
        }
        return frontElement;
    }
}
