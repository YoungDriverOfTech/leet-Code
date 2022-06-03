package hash;

import top200.Solution;

import java.util.*;

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

    // 小根堆
    public int[] topKFrequent_1(int[] nums, int k) {

        // 用一个map统计处每个元素出现的次数
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        // 因为小根堆最小的元素在堆顶，所以一旦出现堆size超过k的情况，那么就把最小的元素给拿出去，这样等遍历完以后，堆里面剩下的就是前k大的元素
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
