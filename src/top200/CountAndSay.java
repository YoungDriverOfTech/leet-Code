package top200;

public class CountAndSay {

    // https://leetcode-cn.com/problems/count-and-say/solution/by-a_tao-9yjh/
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();   // 字符串的商都
            int count = 1;  // 每个字符出现的次数

            for (int j = 1; j < len; j++) {
                // 如果字符和前一个字符不同，那么就需要追加道sb里面
                if (s.charAt(j - 1) != s.charAt(j)) {
                    sb.append(count).append(s.charAt(j - 1));

                    // 一个字符追加完毕，要初始化count次数
                    count = 1;
                } else {
                    count++;
                }
            }

            // 添加长度和字符
            s = sb.append(count).append(s.charAt(len - 1)).toString();
        }

        return s;
    }

    public static void main(String[] args) {
        new CountAndSay().countAndSay(4);
    }
}
