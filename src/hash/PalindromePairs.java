package hash;

import java.util.*;

public class PalindromePairs {


    /**
     * 判断两个字符串是不是回文串，那么有三种情况需要考虑 例如 x 和 y
     * 1. x.length == y.length  ->  那么x和y其中只要有一个能反转一下就OK。比如 abc  cba
     * 2. x.length >  y.length  ->  那么x需要分成两部分，从头开始截取x.sub(0, y.length + 1)的结果反转，应该和y字符串相等，且x剩下的部分应该是回文串。 例如  abcd  cba
     * 3. x.length <  y.length  ->  道理同上   abc  dcba
     *
     * 例子走读   判断abcd  cba
     * 1. 想把这两个字符串反转一下，然后存入list中  list=[dcba, cba]
     * 2. 然后把反转后的字符串当作key，索引当作value，存入一个map中 map=[{dcba, 0}, {cba, 0}]
     * 3. 遍历传进来的words数组，现在当前的字符串是abcd，然后逐位缩减，遍历这个字符串
     * 4. 遍历到   a -> 判断a是否是会文 -> 判断到最后一位d是个回文 -> 那么把前三位当作key去map里面找，找到的话把索引拿出来，和当前字符串的索引一起放入答案中
     * */

    private List<String> wordsReverse = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();


    public List<List<Integer>> palindromePairs(String[] words) {
        // 反转字符串存入全局list和map中
        for (String str : words) {
            wordsReverse.add(new StringBuilder(str).reverse().toString());
        }
        for (int i = 0; i < wordsReverse.size(); i++) {
            map.put(wordsReverse.get(i), i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }

            for (int j = 0; j <= word.length(); j++) {
                // case1: abcd  (cba) 应该遍历到第四个字符d，判断回文且前面的三个字符应该能在map中找到
                if (isPalindrome(word, j, word.length() - 1)) {   // 注意 这里用的是索引，不是截取字符串，所以不用考虑左闭右开
                    // d是回文字串，那么abc应该能在map中找到
                    String subStr = word.substring(0, j);      // 注意 这里是截取字符串，要考虑左闭右开
                    int index = findWord(subStr);   // 可以与之组成回文串的字符串的索引
                    if (index != -1 && index != i) {
                        result.add(Arrays.asList(i, index));
                    }
                }

                // case2: (abc) dcba 应该遍历到第一个字符a，然后判断回文，且后面的三个字符应该能在map中找到
                if (j != 0 && isPalindrome(word, 0, j - 1)) {   // 注意 这里用的是索引，不是截取字符串，所以不用考虑左闭右开
                    String subStr = word.substring(j);    // 注意 这里是截取字符串，要考虑左闭右开
                    int index = findWord(subStr);   // 可以与之组成回文串的字符串的索引

                    //  && leftId != i 是为了排除重复统计，比如只有一个s字符串的话，
                    // 那么会产生重复的索引放入结果中去，所以要在在map中查询出来的索引，不能等于这个字符串在words中的索引
                    if (index != -1 && index != i) {
                        result.add(Arrays.asList(index, i));
                    }
                }
            }
        }
        return result;

    }

    private boolean isPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    private int findWord(String key) {
        return map.getOrDefault(key, -1);
    }



    // 暴力解法，超时
    public List<List<Integer>> palindromePairs_1(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        // 两重循环，遍历前一个元素和其之后的每一个元素是否能组成回文串
        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }

                if (isPalindrome(words[j] + words[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    result.add(list);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePairs().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }
}
