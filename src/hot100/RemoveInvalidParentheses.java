package hot100;

import java.util.*;

public class RemoveInvalidParentheses {

    // https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/java-bfs-hui-su-liang-chong-fang-fa-shi-pin-jiang-/
    public List<String> removeInvalidParentheses(String s) {

        List<String> res = new ArrayList<>();

        if (s == null) {
            return res;
        }

        // 初始化
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.add(s);

        // 先明确题目要求的是删除最少的字符，可推出一旦找出删除最少的字符的某一个结果，那么删除更多的字符的结果就不能要了
        boolean found = false;

        while (!queue.isEmpty()) {

            // 以为"()())()"为例子
            s = queue.poll();

            // 一旦找到了最长的合法字符串，那么就把found设置为true，因为删除更多的字符就不符合题意了
            // 第二次循环到这里)())()不合规，会进行下一轮循环，并且把心的字符串添加进queue,因为下一轮循环的全是5个字符，所以一定不会规
            // (())() 符合条件，那么会把found重置为true，以后则不会再queue添加新的字符串了
            if (isValid(s)) {
                res.add(s);
                found = true;
            }

            if (found) {
                continue;
            }

            // 依次删除字符串的每一个字符，然后添加进queue中
            for (int i = 0; i < s.length(); i++) {
                // 如果碰到非（）的，就continue
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }

                // 然后把第i位删除,然后添加进队列中，此次的例子会把以下的字符串添加进去
                // )())()  (())()  ()))()  ()()()  ()()()这个重复了不添加  ()()))  ()())(
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    visited.add(t);
                    queue.add(t);
                }
            }
        }

        return res;
    }

    // 判断字符串里面的括号是否合法
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            }

            if (ch == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        new RemoveInvalidParentheses().removeInvalidParentheses("()())()");
    }
}
