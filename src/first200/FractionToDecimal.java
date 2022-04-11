package first200;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    // https://leetcode-cn.com/problems/fraction-to-recurring-decimal/solution/gong-shui-san-xie-mo-ni-shu-shi-ji-suan-kq8c4/
    public String fractionToDecimal(int numerator, int denominator) {
        // 将除数被除数转换成long，防止溢出
        long a = numerator;
        long b = denominator;

        // 如果能除尽，那么直接返回他们的商
        if (a % b == 0) {
            return String.valueOf(a / b);
        }

        // 如果有一个数字是符号，那么就要在结果里面加上符号
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);

        // 计算小数点前的部分，并将余数赋值给 a
        sb.append(String.valueOf(a / b) + ".");
        a = a % b;

        // 用map来存放最初的余数，如果在后面的除法中发现最初的，那么就出现了循环的结果
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在的位置，所应该被插入的位置，以后方便把商，插入进去
            map.put(a, sb.length());

            a *= 10;
            sb.append(String.valueOf(a / b));
            a = a % b;

            if (map.containsKey(a)) {
                int index = map.get(a);
                return String.format("%s(%s)", sb.substring(0, index), sb.substring(index));
            }
        }

        return sb.toString();
    }
}
