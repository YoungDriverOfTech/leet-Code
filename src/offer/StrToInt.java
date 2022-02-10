package offer;

public class StrToInt {
    // explanation : https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solution/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        // 判断第一个字符是不是有效字符（为正负号或者数字），如果不是的话直接返回0  注意，这里的条件要用&&
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) < '0' || str.charAt(0) > '9')) {
            return 0;
        }

        // 把有效的字符串拼接起来
        StringBuilder result = new StringBuilder(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            result.append(str.charAt(i));
        }

        // 如果只有正负号的话，那么就返回0
        if (result.toString().length() == 1 && (result.toString().charAt(0) == '+' || result.toString().charAt(0) == '-' )) {
            return 0;
        }

        // 判断边界值
        // 获取Integer的最大值最小值的字符串
        double MAX_INT = Integer.MAX_VALUE;
        double MIN_INT = Integer.MIN_VALUE;
        double resultDouble = Double.parseDouble(result.toString());
        if (resultDouble > MAX_INT) {
            return Integer.MAX_VALUE;
        }

        if (resultDouble < MIN_INT) {
            return Integer.MIN_VALUE;
        }

        return Integer.parseInt(result.toString());
    }

    public int strToInt_1(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt("3.14159"));
    }
}
