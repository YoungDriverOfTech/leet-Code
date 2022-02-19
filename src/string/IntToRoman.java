package string;

public class IntToRoman {

    // https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcod-75rs/
    int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];

            while (num >= value) {
                num -= value;
                sb.append(symbols[i]);
            }

            if (num == 0) {
                break;
            }
        }

        return sb.toString();
    }
}
