package first200;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    // 每一层的首尾元素用1填充，其余的元素则是上层自己的索引值和索引-1的值的和
    // https://leetcode-cn.com/problems/pascals-triangle/solution/yang-hui-san-jiao-by-leetcode-solution-lew9/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }

        return result;
    }
}
