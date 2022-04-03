package first200;

public class Reverse {
    public int reverse(int x) {
        int LIMITATION = Integer.MAX_VALUE / 10;
        int sign = 1;

        String xStr = String.valueOf(x);
        // 确定最后结果是正号还是负号
        if (xStr.charAt(0) == '-') {
            sign = -1;
            xStr = xStr.substring(1);
        }

        int result = 0;
        char[] chars = xStr.toCharArray();

        // 因为需要反转字符串，所以从后往前遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];

            // 退出条件, 如果当前的累加值已经超过界限值，那么就退出
            if (result > LIMITATION || (result == LIMITATION && ch > '7')) {
                return 0;
            }


            result = result * 10 + (ch - '0');
        }

        return result * sign;
    }
}
