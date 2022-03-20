package tree;

import java.util.HashMap;
import java.util.Map;

public class NumTrees {
    private Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        // 使用map是为了防止重复的计算，浪费了时间
        if (map.containsKey(n)) {
            return map.get(n);
        }

        // 遍历数组，某个跟节点的左子树节点数量是i-1, 右子树节点数量是n-i
        // 那么找到左子树和右子树的节点数量，然后相乘就是结果
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            count += leftNum * rightNum;
        }

        map.put(n, count);
        return count;
    }
}
