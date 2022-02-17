package string;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    // https://leetcode-cn.com/problems/minimum-window-substring/solution/shu-ju-jie-gou-he-suan-fa-hua-dong-chuan-p6ip/
    public String minWindow(String s, String t) {

        // 存储t中的字符以及出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, startIndex = 0, length = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 取出s中的字符，判断在t中出现过没有，有的话那么把map中该数字的数量-1, 然后移动右指针
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
            right++;

            // 判断到目前为止，t中出现的字符有没有被完全覆盖，即所有字符的数量降到0及以下
            while (checkCount(map)) {
                // 取到最短的长度，并且记录起始位置，用于最后返回
                if (right - left < length) {
                    startIndex = left;
                    length = right - left;
                }

                // 指针左移用于删除首个字符，如果首个字符在t中出现过，那么要更新这个字符在map中的数量。因为map存的是t中各字符的数量
                // 而遍历s会消耗这个数量，现在由于指针移动，被s消耗的数量，需要再加回来
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
        }

        if (length != Integer.MAX_VALUE) {
            return s.substring(startIndex, startIndex + length);
        }
        return "";
    }

    private boolean checkCount(Map<Character, Integer> map) {
        for (int i : map.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
