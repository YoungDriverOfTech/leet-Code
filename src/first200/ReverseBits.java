package first200;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // 判断n的最后一位是不是1，如果是1，那么就把这个1 ，传递给result
            // 然后一次把n，往右边推, 这样n的从右到左的1，回变成result从左到右的1
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }
}
