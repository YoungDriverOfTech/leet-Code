package orderbyasc;

import java.util.List;

public class MinimumTotal {

    // 二维数组
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i][j] 表示在三角形中第i层，第j个元素的最小和
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();
        int [][] dp = new int[rows][cols];

        // 我们从最底层开始遍历，计算每个元素的最小和
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // 如果是最后一行，那么dp的值就是对应的triangle的值
                if (row == rows - 1) {
                    dp[row][col] = triangle.get(row).get(col);
                } else {
                    // 如果不是最后一行，那么最小和值=当前元素值 + Math.min(下一行当前索引对应的值， 下一行当前索引+1对应的值);
                    dp[row][col] = triangle.get(row).get(col) + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
                }
            }
        }

        return dp[0][0];
    }


    // https://leetcode-cn.com/problems/triangle/solution/shou-hua-tu-jie-dp-si-lu-120-san-jiao-xing-zui-xia/
    // 一维数组
    public int minimumTotal_1(List<List<Integer>> triangle) {
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
