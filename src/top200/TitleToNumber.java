package top200;

public class TitleToNumber {

    // https://leetcode-cn.com/problems/excel-sheet-column-number/solution/gong-shui-san-xie-tong-yong-jin-zhi-zhua-y5fm/
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int len = columnTitle.length();

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res * 26 + (chars[i] - 'A' + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        char a = 'C';
        System.out.println(a - 'B');
    }
}
