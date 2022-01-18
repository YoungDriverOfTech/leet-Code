package offer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinNumber {

    // 解题思路： https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/wei-shi-yao-ta-shi-yi-ge-pai-xu-wen-ti-b-hh21/
    public String minNumber_1(int[] nums) {
        List<String> list = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i) + list.get(j)).compareTo((list.get(j) + list.get(i))) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }

    // sort with comparator
    public String minNumber(int[] nums) {

        String[] numStringArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStringArray[i] = String.valueOf(nums[i]);
        }

        // Sort with specified order rule
        Arrays.sort(numStringArray, (pre, cur) -> (pre + cur).compareTo(cur + pre));

        StringBuilder sb = new StringBuilder();
        for (String s : numStringArray) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinNumber().minNumber(new int[]{2, 10}));
    }
}
