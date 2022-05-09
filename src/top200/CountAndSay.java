package top200;

public class CountAndSay {

    // https://leetcode-cn.com/problems/count-and-say/solution/by-a_tao-9yjh/
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
