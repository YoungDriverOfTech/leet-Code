package offer;

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

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(2, 3, 1));
    }
}
