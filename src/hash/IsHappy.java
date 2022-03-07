package hash;

public class IsHappy {
    // 解析 https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
    // 快慢指针法，快指针走两步两步走，慢指针一步一步走，如果发生了循环，那么快指针一定会追上满指针，这时候退出就可以了
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            sum += temp * temp;
        }
        return sum;
    }
}
