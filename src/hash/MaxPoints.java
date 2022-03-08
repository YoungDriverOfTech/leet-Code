package hash;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    // 遍历每个点和以后的点所组成的斜率是不是相同的，如果是相同的，那么说明这两个点就在在一条直线上的
    // https://leetcode-cn.com/problems/max-points-on-a-line/solution/gong-shui-san-xie-liang-chong-mei-ju-zhi-u44s/
    public int maxPoints(int[][] points) {
        int result = 1;
        // 这次循环用来取出每一个点
        for (int i = 0; i < points.length; i++) {
            // 这个map用来存储每个点相同斜率的数量
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            // 这次循环用来取出下一个点
            for (int j = i + 1; j < points.length; j++) {
                // 获得两个点的坐标，然后计算出dealtX dealtY
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dealtX = x2 - x1;
                int dealtY = y2 - y1;

                // 获得最大公约数
                int k = gcd(dealtX, dealtY);

                // 使用最大公约数，组成一个key，然后存入map中
                String key = (dealtX / k) + "_" + (dealtY / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max + 1); // 这里为什么要加1呢？ 因为第二重循环的时候并没有把第一种循环的那个点给加上，所以要在这里加上
        }

        return result;
    }

    // 求最大公约数
    private int gcd(int dealtX, int dealtY) {
        return dealtY == 0 ? dealtX : gcd(dealtY, dealtX % dealtY);
    }

    public static void main(String[] args) {
        int[][] param = new int[][]{{1,1},{2,2},{3,3}};
        System.out.println(new MaxPoints().maxPoints(param));
    }
}
