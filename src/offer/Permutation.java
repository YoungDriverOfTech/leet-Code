package offer;

import java.util.*;

public class Permutation {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);

        return res.toArray(new String[res.size()]);
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


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("abc")));
    }
}
