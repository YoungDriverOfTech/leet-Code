package first200;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
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
