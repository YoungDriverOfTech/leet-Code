package hash;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
    // https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
    // 第二遍做的时候，学习一下什么是大小堆
    // 此方法暂时不满足follow up，第二遍做的时候再看follow up吧
    public int[] topKFrequent(int[] nums, int k) {
        // 把数组里面元素和出现的次数放入map中，并且找到最大的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 找到最大的次数
        int maxTimes = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxTimes = entry.getValue() > maxTimes ? entry.getValue() : maxTimes;
        }

        // 把满足条件的元素放入结果数组中然后返回
        int[] result = new int[k];
        while (k > 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();

                if (count == maxTimes) {
                    result[k - 1] = num;
                    k--;
                }
            }
            maxTimes--;
        }

        return result;
    }
}
