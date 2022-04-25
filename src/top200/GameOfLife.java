package top200;

public class GameOfLife {
    // 在暴力解法的基础上做一些修改，如果我们增加两个状态，-1代表 活->死. 2代表 死->活，那么我们就不用创建新的数组了
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, -1, 1};
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neightborNum = 0;

                // 开始统计周围一圈的活着的邻居数量
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (!(neighbors[x] == 0 && neighbors[y] == 0)) {
                            int r = i + neighbors[x];
                            int c = j + neighbors[y];

                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && Math.abs(board[r][c]) == 1) {
                                neightborNum++;
                            }
                        }
                    }
                }

                // 规则1 和3
                if (board[i][j] == 1 && (neightborNum < 2 || neightborNum > 3)) {
                    board[i][j] = -1;
                }

                // 规则4
                if (board[i][j] == 0 && neightborNum == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // 把-1变成0，然后把2变成1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }

                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }

                // if (board[i][j] > 0) {
                //     board[i][j] = 1;
                // } else {
                //     board[i][j] = 0;
                // }

            }
        }
    }


    // 暴力解法
    // 时间空间复杂度都是O（mn），因为需要新建一个数组
    // 题目说的是一个格子，他上下左右围着他一圈的8个方向
    public void gameOfLife_1(int[][] board) {
        int[] neighbors = {0 , -1, 1};

        // 复制一个board数组，用来判断。因为原来的board需要改变，所以必须要复制一个新的
        int rows = board.length;
        int cols = board[0].length;
        int[][] copiedBoard = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copiedBoard[i][j] = board[i][j];
            }
        }

        // 遍历数组，并且统计每个格子一周的存活的格子数量，然后根据规则改变值就可以了
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighborNum = 0;

                // 只有同时不为0的时候，才进去统计，因为同时为0的话，就是指元素自己本身了
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (!(neighbors[x] == 0 && neighbors[y] == 0)) {
                            // 取到周围一圈的坐标
                            int r = i + neighbors[x];
                            int c = j + neighbors[y];

                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && copiedBoard[r][c] == 1) {
                                neighborNum++;
                            }
                        }
                    }
                }

                // 根据题目规则，改变board的值
                // 规则1 3
                if (copiedBoard[i][j] == 1 && (neighborNum < 2 || neighborNum > 3)) {
                    board[i][j] = 0;
                }

                // 规则4
                if (copiedBoard[i][j] == 0 && neighborNum == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }


}
