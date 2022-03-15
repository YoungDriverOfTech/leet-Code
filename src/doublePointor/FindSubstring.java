package doublePointor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    // https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-6/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        // 如果数组里面不包含任何单词，直接返回空list
        int wordSize = words.length;
        if (wordSize == 0) {
            return res;
        }

        // 如果数组里面的单词的总长度 > 字符串s的总长度，则直接返回空
        int singleSize = words[0].length();
        int totalSize = singleSize * wordSize;
        if (totalSize > s.length()) {
            return res;
        }

        // 把数组里面出现的单词当作key，次数当作value，放入map中去
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 逐位遍历s字符串，长度是总长度，然后单领出来每个单词，放入一个新map中，判断其数量和上面的map数量相不相同
        // 如果相同，说明当前单词匹配上了，判断下一个单词，如果不同，那么说明i开头的字符串不匹配，让i+1，继续遍历
        for (int i = 0; i <= s.length() - totalSize; i++) {
            Map<String, Integer> tempMap = new HashMap<>();
            String tempStr = s.substring(i, i + totalSize); // 索引为i的时候，应该被判断的字符串
            int num = 0;

            // 如果所有的单词都背判断完了，那么就进行下一轮循环
            while (num < wordSize) {
                String word = tempStr.substring(num * singleSize, (num + 1) * singleSize);
                if (map.containsKey(word)) {
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                    if (tempMap.get(word) > map.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }

            if (num == wordSize) {
                res.add(i);
            }
        }

        return res;
    }
}
