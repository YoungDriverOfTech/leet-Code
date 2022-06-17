package string;

import java.util.*;

public class GroupAnagrams {
    /**
     * 把每个字符串排序后的结果当作key，排序前的字符串当作value放进map里面，那么map的values就是结果
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);

            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }


}
