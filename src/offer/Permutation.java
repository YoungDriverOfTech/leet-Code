package offer;

import java.util.*;

public class Permutation {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);

        return res.toArray(new String[0]);
    }

    private void dfs(int startIndex) {

        // 遍历的最后一个元素后，把结果装进list然后返回
        if (startIndex == c.length) {
            res.add(String.valueOf(c));
            return;
        }

        // 定义set，用来check重复元素
        Set<Character> set = new HashSet<>();
        for (int i = startIndex; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }

            // 交换元素后进行，后面元素的交换。整个交换完成后，记得再交换回来，为下一轮做准备
            set.add(c[i]);
            swap(startIndex, i);
            dfs(startIndex + 1);
            swap(startIndex, i);
        }
    }

    private void swap(int startIndex, int i) {
        char tmp = c[startIndex];
        c[startIndex] = c[i];
        c[i] = tmp;
    }

    // second time
    public String[] permutation_1(String s) {
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Set<String> list = new HashSet<>();

        dfs_1(chars, visited, list, "");

        return list.toArray(new String[0]);
    }

    private void dfs_1(char[] chars, boolean[] visited, Set<String> list, String s) {
        if (s.length() == chars.length) {
            list.add(s);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs_1(chars, visited, list, s + chars[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("abc")));
    }
}
