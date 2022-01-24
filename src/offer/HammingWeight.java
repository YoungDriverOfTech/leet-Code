package offer;

public class HammingWeight {
    // 　explanation: https://www.bilibili.com/video/BV1YT4y117AH?p=4
    //  n & n - 1， 会把n（二进制表示）的最右边的1给消掉，已经验证过了。所以这题只要看消除了几次，就能找出一共右几个1
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
