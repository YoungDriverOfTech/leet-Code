package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        int result = 0;
//        "pwwkew"

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            while (list.contains(aChar)) { // must use while loop to keep no duplicated element in list
                list.removeFirst();
            }
            list.addLast(aChar);
            result = Math.max(result, list.size());
        }
        return result;
    }

    public int lengthOfLongestSubstring_1(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstring_2(String s) {
        if(s.length() == 0) return 0;
        int appear[] = new int[128];
        int left = 0;
        int right = 0;
        int maxLength = 1;
        while(right < s.length()){
            if(appear[s.charAt(right)] == 0){
                appear[s.charAt(right)]++;
                maxLength = Math.max(maxLength,right-left+1);
                right++;
            }
            else{
                appear[s.charAt(right)]++;
                while(appear[s.charAt(right)] > 1){
                    appear[s.charAt(left)]--;
                    left++;
                }
                right++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestSubString().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new LongestSubString().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubString().lengthOfLongestSubstring("pwwkew"));
    }
}
