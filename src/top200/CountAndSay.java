package top200;

public class CountAndSay {

    // https://leetcode-cn.com/problems/count-and-say/solution/by-a_tao-9yjh/
    // time O(n * m) 其中 N 为给定的正整数，M 为生成的字符串中的最大长度。
    // space O(m) M 为生成的字符串中的最大长度。
    public String countAndSay(int n) {
        // 让索引从1开始，方便计算
        String s = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < s.length()) {
                while (pos < s.length() && s.charAt(start) == s.charAt(pos)) {
                    pos++;
                }
                sb.append(pos - start).append(s.charAt(start));

                // 遍历下一个字符
                start = pos;
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        new CountAndSay().countAndSay(4);
    }
}
