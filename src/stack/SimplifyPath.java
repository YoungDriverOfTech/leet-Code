package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // item 为有效值 ：存入栈中；
        // item 为 .. ：弹出栈顶元素（若存在）；
        // item 为 . ：不作处理。
        Deque<String> stack = new ArrayDeque<>();
        int n = path.length();

        for (int i = 1; i < n;) {

            // 无效的字符，或者多余的/，都不需要放入栈中
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }

            // 从i以后的元素往后找，一直找到/，然后截取字符串，判断是否是有效的字符串
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {    // 注意，写的时候不要把i写成了j之类的
                j++;
            }
            String item = path.substring(i, j);

            // item 为 .. ：弹出栈顶元素（若存在）；
            // item 为 . ：不作处理。
            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!item.equals(".")) {
                stack.addLast(item);
            }

            i = j;
        }

        // 把栈里面的有效字符取出来，拼接成结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        new SimplifyPath().simplifyPath("/home//foo/");
    }
}
