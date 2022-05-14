package top200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);

        // 假定空字符串是存在于字符串字典中的，dp[0] = true;
        // dp[i]表示,(0,i)中间的字符串是否在字典中包含
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        // i左到右遍历每个字符，然后j从i开始往左边走，截取下来字符串str =【j，i】，如果str是存在于字典中的话，那么dp[i]的结果
        // 就取决于dp[j],即 字典.contains(str) && do[j] == true
        // 因为j需要一直减到0，如果dp[0]是false的话，那么转移方程永远不成立，所以我们需要让dp[0] = true
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String str = s.substring(j, i);

                // 如果动态转移方程已经满足，那就退出当前循环
                if (set.contains(str) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        new WordBreak().wordBreak("leetcode", list);
    }
}
