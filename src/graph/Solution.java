package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] end) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return -1;
        }

        // 记忆化搜索：记录start到该点(x, y)的最小步数
        int m = maze.length;
        int n = maze[0].length;
        int[][] memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        memo[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];

                // 直到移动到墙上, 最后上墙了，需要在往后走一步
                int step = 0;
                while (changeRange(maze, newX, newY) && maze[newX][newY] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                    step++;
                }
                newX -= dx[i];
                newY -= dy[i];

                // 什么时候能够入队
                if (memo[newX][newY] > memo[point[0]][point[1]] + step) {
                    memo[newX][newY] = memo[point[0]][point[1]] + step;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return memo[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : memo[end[0]][end[1]];
    }

    private boolean changeRange(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
