package first200;

import java.util.*;

public class GetSkyline {

    // https://www.bilibili.com/video/BV1yq4y1J73s?spm_id_from=333.337.search-card.all.click
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> points = new ArrayList<>();
        // 把buildings做预处理，把每个矩形的竖线装进points中，因为要区分左右，所以把左边的竖线的高度先设置成为负数
        for (int[] b : buildings) {
            points.add(Arrays.asList(b[0], -b[2]));
            points.add(Arrays.asList(b[1], b[2]));
        }

        // 吧points按照横坐标升序排序，如果横坐标相等，则按照高度生序排序
        points.sort((o1, o2) -> {
            int x1 = o1.get(0);
            int y1 = o1.get(1);
            int x2 = o2.get(0);
            int y2 = o2.get(1);
            if (x1 != x2) {
                return x1 - x2;
            }
            return y1 - y2;
        });

        // 使用大根堆来存放高度，如果最大高度发生了变化，说明出现了关键点，那么就要加入到结果集中。 如果出现了相同的高度，那么说明一个矩形的第二条线被找到，那么我们需要在大根堆中弹出对应的高度
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.offer(0);
        int preMax = 0;

        for (List<Integer> p : points) {
            int x = p.get(0);
            int y = p.get(1);

            // 向大根堆里面追加或者删除高度
            if (y < 0) {
                queue.offer(-y);
            } else {
                queue.remove(y);
            }

            // 判断高度是否发生了变化
            int curMax = queue.peek();
            if (curMax != preMax) {
                res.add(Arrays.asList(x, curMax));
                preMax = curMax;
            }

        }
        return res;
    }
}
