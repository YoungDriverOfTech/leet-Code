package hash;

import top200.Solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
