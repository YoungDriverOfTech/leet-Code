package orderbyasc;

public class GetPermutation {
    // https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
    // https://www.bilibili.com/video/BV1PJ411E7Dm?spm_id_from=333.337.search-card.all.click
    public String getPermutation(int n, int k) {
        // 给出n = 4， k = 9求出第三个位置的字符串
        // 首先我们根据递推公式可得n个数字，一共有！n种排列方式，假设有【1,2,3,4】位数字
        // 1. 当把首位数字先固定为1，那么剩下的排列方式还有1*2*3 = 6种，意思是如果首位为1，那么最后能出现6种组合，远远达不到k的9种
        // 2. 首位固定为2，因为首位为1的时候已经可以排除掉6中可能性了，所以剩下的k就只有3. 那么开头为2也有用6中排列组合，6>3(新k)，所以答案开头字符一定是2，确定了开头是2
        // 3. 寻找下一位，现在的情况转换成了一个小问题n=【1，3，4】k=3，假如我们固定开头为1，那么有2种排列，2<3(新k),所以开头不能是1
        // 4. 因为首位为1的时候已经可以排除掉2中可能性了，所以k现在就只剩下1。那么开头固定为3，3也有两种排列2>1(新k),所以固定为了3
        // 5. 寻找下一位，现在的情况转换成了一个小问题n=【1，4】k=1，假如我们固定开头为1，那么有1种排列，1=k，所以这轮的首位就是1，那么最后一位就是4了

        // 定义阶乘数组
        int[] p = new int[n + 1];
        p[0] = p[1] = 1;
        for (int i = 2; i <= n; i++) {
            p[i] = p[i - 1] * i;
        }

        // 如果一个数字已经被访问过了，那么就不能被再次使用
        boolean[] visited = new boolean[n + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    continue;
                }

                if (p[n - 1 - i] < k) {
                    k -= p[n - 1 - i];
                } else {
                    visited[j] = true;
                    sb.append(j);
                    break;
                }
            }
        }

        return sb.toString();
    }


    // 普通回溯，超时
    /**
     *     private String res = "";
     *     private int k;
     *
     *     public String getPermutation(int n, int k) {
     *         this.k = k;
     *         boolean[] visited = new boolean[n];
     *         backTrack(n, "", visited);
     *
     *         return res;
     *     }
     *
     *     private void backTrack(int n, String curVal, boolean[] visited) {
     *         if (curVal.length() == n) {
     *             k--;
     *             if (k == 0) {
     *                 res = curVal;
     *             }
     *             return;
     *         }
     *
     *         for (int i = 0; i < n; i++) {
     *             if (visited[i]) {
     *                 continue;
     *             }
     *
     *             visited[i] = true;
     *
     *             backTrack(n, curVal + (i + 1), visited);
     *
     *             visited[i] = false;
     *         }
     *     }
     * */
}
