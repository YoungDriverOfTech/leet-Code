package order;

public class HIndex {
    // 题意解释
    // https://leetcode-cn.com/problems/h-index/solution/er-fen-cai-lun-wen-pian-shu-java-by-liwe-zoh7/
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int count = 0;

            for (int num : citations) {
                if (num >= mid) {
                    count++;
                }
            }

            if (mid <= count) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
