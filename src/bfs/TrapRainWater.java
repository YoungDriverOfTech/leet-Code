package bfs;

import java.util.PriorityQueue;

public class TrapRainWater {
    // https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/xiao-song-man-bu-you-xian-dui-lie-cong-w-r9f6/
    public int trapRainWater(int[][] heightMap) {
        // 解决特殊情况
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }

        // 将最外面一圈按照高度从小到大的三坐标放入到队列中，为了完成这个任务需要使用有限队列
        // 并且把每个点标记为已经访问过的
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.offer(new int[]{i, j , heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }


        // 遍历高度数组，如果发现的点是圈内的点，并且高度小于圈的高度那么就去灌水，然后把圈往里面缩，但是高度要取圈和相邻节点的较大值
        int res = 0;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // 依此遍历上下左右四个点
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dir[i];
                int nextY = cur[1] + dir[i + 1];

                // 如果下一个点的坐标是圈内的点的话，就要进行判断
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    int temp = cur[2] - heightMap[nextX][nextY];
                    if (temp > 0) {
                        res += temp;
                    }

                    // 缩小圈子并且标记为已访问过
                    queue.offer(new int[]{nextX, nextY, Math.max(cur[2], heightMap[nextX][nextY])});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return res;
    }
}
