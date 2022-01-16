package offer;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        boolean[][] visited = new boolean[m][n];
        dps(0, 0, m, n, k, visited); // visited will be filled true or false, and count true is final result

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // Depth-First-Search 深度优先
    private void dps(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || get(i) + get(j) > k) {
            return;
        }

        visited[i][j] = true;

        dps(i + 1, j, m, n, k, visited);
        dps(i - 1, j, m, n, k, visited);
        dps(i, j + 1, m, n, k, visited);
        dps(i, j - 1, m, n, k, visited);
    }

    // breath-First-Search 深度优先
    private int bps(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int result = 0;

        while (!queue.isEmpty()) {
            int[] indexes = queue.poll();
            int x = indexes[0];
            int y = indexes[1];

            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || get(x) + get(y) > k) {
                continue;
            }
            visited[x][y] = true;
            result++;
            for (int i = 0; i < 2; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                queue.add(new int[]{tx, ty});
            }
        }

        return result;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10; // 取余数
            x /= 10; // 求商
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(2, 3, 1));
        System.out.println(new MovingCount().bps(2, 3, 1));
    }
}
