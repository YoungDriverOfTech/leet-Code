package top200;

public class LongestCommonPrefix {

    // https://leetcode-cn.com/problems/longest-common-prefix/comments/
    // time O(mn) n是单词平均长度
    // space O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                if (prefix.length() == 0) {
                    return "";
                }

                //公共前缀不匹配就让它变短！
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
