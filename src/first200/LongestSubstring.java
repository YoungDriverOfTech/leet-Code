package first200;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    // https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
     public int longestSubstring(String s, int k) {
         if (s.length() < k) {
             return 0;
         }

         // 统计每个字符出现的次数
         Map<Character, Integer> count = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);    // 注意不要被参数搞错了
         }

         // 遍历count，如果字符出现的次数小于K了，那么就按照这个字符来分割字符串，那么剩下的就是长度大于k的字符串了
         for (char ch : count.keySet()) {
             if (count.get(ch) < k) {
                 int max = 0;
                 for (String str : s.split(String.valueOf(ch))) {
                     max = Math.max(max, longestSubstring(str, k));
                 }
                 return max;
             }
         }

         return s.length();
     }
}
