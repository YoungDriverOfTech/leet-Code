package string;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> list = new ArrayList<>();
        backTrack(list, phoneMap, 0, new StringBuilder(), digits);

        return list;
    }


    private void backTrack(List<String> list, Map<Character, String> phoneMap, int index, StringBuilder sb, String digits) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }

        // eg 23
        // ch: 2, str: abc ---> ch: 3, str: def
        char ch = digits.charAt(index); // 遍历给定参数的数字字符
        String str = phoneMap.get(ch);  // 取出该数字字符对应的字符串

        // sb: a ---> sb: d,e,f
        // --->b ---> sb: d,e,f
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTrack(list, phoneMap, index + 1, sb, digits);
            sb.deleteCharAt(index);

        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
