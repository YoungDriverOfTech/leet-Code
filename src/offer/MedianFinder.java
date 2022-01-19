package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {

    // https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
    private double median;
    private List<Integer> container;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.median = 0;
        this.container = new ArrayList<>();
    }

    public void addNum(int num) {
        this.container.add(num);
        Collections.sort(this.container);

        int middleIndex = this.container.size() / 2;
        if (this.container.size() % 2 == 0) {
            this.median = ((this.container.get(middleIndex) + this.container.get(middleIndex - 1)) / (2 * 1.0)) ;
        } else {
            this.median = this.container.get(middleIndex);
        }
    }

    public double findMedian() {
        return median;
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
