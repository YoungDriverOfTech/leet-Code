package offer;

import java.util.PriorityQueue;

public class MedianFinder {

    // https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
    // 使用优先队列，两个优先队列，左边的那个大根堆（栈顶是最大的元素），右边的那个小根堆（栈顶最小的元素）
    // 比如； left=[1 ,2 ,3, 4, 5] 出队的话是5开始。right=[6, 7, 8, 9, 10]出队的话是6开始
    // 那么我们让两个队列保持数量相等，切left要多一个，如果数量为偶数，那么中位数就是left和right栈顶的和除以2
    // 如果是奇数的话，那么就是栈顶的和
    // https://leetcode-cn.com/problems/find-median-from-data-stream/solution/gong-shui-san-xie-jing-dian-shu-ju-jie-g-pqy8/
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> b - a);   // 放数较小的那一波
        this.right = new PriorityQueue<>((a, b) -> a - b);  // 放数字较大的那一波
    }

    public void addNum(int num) {
        int len1 = this.left.size();
        int len2 = this.right.size();

        if (len1 == len2) {
            // 往左边添加的时候，用右head来判断
            if (right.isEmpty() || num <= right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll()); // 这里不能是pop，必须是poll， 因为队列不是栈
                right.add(num);
            }

        } else {
            // 往右添加的时候，用左head来判断
            if (num >= left.peek()) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        int len1 = this.left.size();
        int len2 = this.right.size();

        if (len1 == len2) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) left.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        double median1 = medianFinder.findMedian();

        medianFinder.addNum(3);
        double median2 = medianFinder.findMedian();
    }
}
