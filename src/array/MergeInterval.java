package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    // https://leetcode-cn.com/problems/merge-intervals/solution/56-he-bing-qu-jian-jian-dan-yi-dong-liao-uxbo/
    public int[][] merge(int[][] intervals) {
        // 先把intervals进行排序，先按照第一个元素，然后是第二个
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        // 定义开始和结束为止，如果当前的开始位置<上次的结束位置，说明有重叠，那么进行合并
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                // 如果没有包含重叠部分，那么说明不能进行merge，要将当前的start, end假如到结果list中
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // 把最后一次的结果也假如到list中
        list.add(new int[]{start, end});

        // 把list转换成数组后返回
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
