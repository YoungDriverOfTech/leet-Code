package bs;

public class MySqrt {
    // 求平方根的话，平方根不会超过参数的一半，比如2 -> 3,  3 -> 9
    // 用二分查找算法来计算平方根，每次求出mid的平方与x相比即可
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = 0;

        while (left <= right) { // 这里要小于等于，等号不能忘掉， 如果没有等号 有的case覆盖不到，比如1
            int mid = left + (right - left) / 2;
            if (((long) mid * mid) <= x) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
