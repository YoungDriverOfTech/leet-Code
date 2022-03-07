package hash;

public class IsValidSudoku {
    // https://leetcode-cn.com/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/
    // 分别判断当前数组在每行/每列/每个box中是否出现过
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];  // 为什么二维数组需要10呢，因为如果一个数组出现过的话，要把遍历到的数字，当作索引来用
        int[][] cols = new int[9][10];  // 加入遍历到9了，那么rows[i][9] = 1, 类似这样来存储数组，那么就需要数组比9多一个单位
        int[][] boxes = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // 不要忘记无效值判断
                if (board[i][j]=='.'){
                    continue;
                }

                int curNum = board[i][j] - '0';
                if (rows[i][curNum]==1){
                    return false;
                }if (cols[j][curNum]==1){
                    return false;
                }
                if (boxes[j/3 + (i/3) * 3][curNum]==1){
                    return false;
                }

                // 如果当前数组没有在本行/本列/本box中出现过，那么就把当前元素的位置置为1
                // 注意，这三个数组都是第一维表示当前的行/列/盒子
                rows[i][curNum] = 1;
                cols[j][curNum] = 1;
                boxes[j/3 + (i/3) * 3][curNum] = 1; // j/3 表明是第几列的盒子， (i/3) * 3表明是第几行的盒子，合起来就是第几行地激烈的盒子
            }
        }

        return true;
    }
}
