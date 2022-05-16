package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {
    // 更快的写法，参照 https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
    public String removeDuplicateLetters(String s) {
        // 用hash表来统计每个字符的出现次数
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 用栈来统计每个字符，如果该字符在栈中出现过，那么就进行下一个字符的统计，如果没出现过
        // 那么就要判断当前字符和栈顶的字符的大小，如果当前字符小于栈顶的字符，那么需要把栈顶的字符pop出现、
        // 来保证最小的字典顺序，如果栈顶的字符只剩下最后一个了，那就不要pop了，因为会把必要的字符删除掉

        // 以"cbacdcbc"为例子
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            map.put(ch, map.get(ch) - 1);   // 注意，每遍历一个字符，就要把数量减去1

            // 有重复元素那么就跳过
            if (stack.contains(ch)) {
                continue;
            }

            // 插入之前，和之前的元素比较一下大小
            // 如果字典序比前面的小，pop 前面的元素
            while (!stack.isEmpty() && stack.peek() > ch) {

                // 若之后不存在栈顶元素了，则停止 pop
                if (map.get(stack.peek()) == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                stack.pop();
            }

            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
