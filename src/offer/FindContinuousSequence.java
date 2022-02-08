package offer;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> resultList = new ArrayList<>();

        /*
        * 假设窗口左边界i=target/2, i+1=target/2 +1,那么i + (i+1) = target+1,即最小的窗口的元素之和就已经比target大了，
        * 所以当i>=target/2时不可能有一个窗口长度>=2的答案。 这也归因于本题的特殊要求：答案数组至少包含两个元素。
        *  如果没有上述要求，那么在i>=target/2的范围内还存在当i == target时的结果，窗口长度==1。 这是我的理解，希望为你理解题意提供思路。
        *
        * 解析：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
        * */
        while (left <= target/2) {  // 或者直接小于号也行
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left, j = left; i < right; i++) {      // 注意：i<right 不是小于arr.size()
                    arr[i - j] = i;
                }
                resultList.add(arr);

                // for next loop
                sum -= left;
                left++;
            }
        }

        return resultList.toArray(new int[resultList.size()][]);    // 注意： new int[][] 有两个中括号，不是一个
    }
}
