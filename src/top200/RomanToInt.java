package top200;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));

            // 应该字符串总是大数在前，小数在后，那么当小数在前面的时候，说明出现了特例
            // 比如IV，应该是4，那么就判断后面的I和V谁大，如果后面大，说明这个I应该去上负值 -1， 然后下一轮循环的时候，加上X10， 那么总体
            // 就是加上了9
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public int romanToInt_1(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900); // special
        map.put("D", 500);
        map.put("CD", 400); // special
        map.put("C", 100);
        map.put("XC", 90); // special
        map.put("L", 50);
        map.put("XL", 40); // special
        map.put("X", 10);
        map.put("IX", 9); // special
        map.put("V", 5);
        map.put("IV", 4); // special
        map.put("I", 1);

        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            String key = String.valueOf(chars[i]);

            // for 900/400
            if (key.equals("C") && i + 1 < chars.length && (chars[i + 1] == 'M' || chars[i + 1] == 'D')) {
                key += String.valueOf(chars[i + 1]);
                i++;
            }

            // for 90/40
            if (key.equals("X") && i + 1 < chars.length && (chars[i + 1] == 'C' || chars[i + 1] == 'L')) {
                key += String.valueOf(chars[i + 1]);
                i++;
            }

            // for 9/4
            if (key.equals("I") && i + 1 < chars.length && (chars[i + 1] == 'X' || chars[i + 1] == 'V')) {
                key += String.valueOf(chars[i + 1]);
                i++;
            }

            result += map.get(key);
            i++;
        }

        return result;
    }
}
