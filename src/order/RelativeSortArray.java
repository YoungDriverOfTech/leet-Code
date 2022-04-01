package order;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 自定义排序
        // 先把arr1装进一个list里面，让他可以使用Collections的sort功能
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }

        // 然后把arr2装进一个map里面，让他作为排序判断的标准，值为key，索引为value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Collections.sort(list, (o1, o2) -> {
            // 如果是arr2中存在的元素，那么map中索引小的排在前面，大的在后面,即索引升序
            if (map.containsKey(o1) || map.containsKey(o2)) {
                // 根据题目的约束条件元素的最大值1000，所以如果在map中不存在的话，那么就要往后排
                // 在map中存在的话，索引升序
                return map.getOrDefault(o1, 1001) - map.getOrDefault(o2, 1001);
            }

            // 默认升序排序
            return o1 - o2;
        });

        int[] result = new int[arr1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
