package string;

import java.util.LinkedList;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();    // sotre non-repeating substring
        int result = 0;

        for (char ch : chars) {

            // remove repead char
            while (list.contains(ch)) {
                list.removeFirst();
            }


            list.add(ch);
            result = Math.max(result, list.size());
        }

        return result;
    }
}
