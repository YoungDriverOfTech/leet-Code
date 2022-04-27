package orderbyasc;

import java.util.List;

public class MinimumTotal {
    // https://leetcode-cn.com/problems/triangle/solution/shou-hua-tu-jie-dp-si-lu-120-san-jiao-xing-zui-xia/
    public int minimumTotal(List<List<Integer>> triangle) {
        // create dp array according to triangle size
        int len = triangle.size();
        int[] dp = new int[len];

        // put bottom list value into dp
        List<Integer> bottomList = triangle.get(len - 1);
        for (int i = 0; i < len; i++) {
            dp[i] = bottomList.get(i);
        }

        //
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
