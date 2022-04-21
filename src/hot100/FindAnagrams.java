package hot100;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    // https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/xiao-song-man-bu-pai-xu-bi-jiao-man-hua-r1d02/
    public List<Integer> findAnagrams(String s, String p) {
        // 定义两个数组，用来装s和p每个字符出现的次数
        int[] sChar = new int[26];
        int[] pChar = new int[26];

        // 统计p中每个字符出现的次数
        for (int i = 0; i < p.length(); i++) {
            pChar[p.charAt(i) - 'a']++;
        }

        // 滑动窗口遍历s
        List<Integer> res = new ArrayList<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 先统计s中每个字符出现的次数
            sChar[s.charAt(right) - 'a']++;

            // 判断边界，如果滑动窗口大于了p的长度，把最左边的字符给去了
            if (right - left + 1 > p.length()) {
                sChar[s.charAt(left++) - 'a']--;
            }

            // 如果正好等于p的长度，那么就需要判断两个数组里面出现的次数是否一致，如果一致那么就加入到res中
            if (isSame(sChar, pChar)) {
                res.add(left);
            }
        }

        return res;
    }

    private boolean isSame(int[] sChar, int[] pChar) {
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != pChar[i]) {
                return false;
            }
        }
        return true;
    }
}
