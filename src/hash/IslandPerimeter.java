package hash;

public class IslandPerimeter {
    // 如果相邻的陆地存在的话，那么就把周长给减上2
    // https://leetcode-cn.com/problems/island-perimeter/comments/
    // 对每一个单元格的左边和上边进行判断是不是土地，因为这样边界操作会比较方便
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
