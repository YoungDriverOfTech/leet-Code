package offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>(); // LinkedHashMap is ordered
        for (int i = 0; i < chars.length; i++) {
            Integer count = map.getOrDefault(chars[i], 0);
            map.put(chars[i], ++count);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }


    public char firstUniqChar_1(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])) {
                return chars[i];
            }
        }
        return ' ';
    }


    public char firstUniqChar_2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }


    public static void main(String[] args) {
        System.out.println(new FirstUniqueChar().firstUniqChar_1("abaccdeff"));
        System.out.println(new FirstUniqueChar().firstUniqChar_1(""));
    }
}
