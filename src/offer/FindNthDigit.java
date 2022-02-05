package offer;

public class FindNthDigit {

    // explanation: https://www.bilibili.com/video/BV1wT4y1N7Vj?from=search&seid=13613594322850151226&spm_id_from=333.337.0.0
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(10));
    }
}
