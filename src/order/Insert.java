package order;

import java.util.Arrays;

public class Insert {
    //    intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //    intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        // 创建一个结果数组
        int len = intervals.length;
        int[][] res = new int[len + 1][2];

        // 遍历intervals，其中每个数组的最大值要和newInterval的最小值比较，如果小的话，说明不会有交集，那么存入res数组中去
        int idx = 0;
        int i = 0;
        while (i < len && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];    // 此时[1, 2]被放入了res结果集中去，指针i现在指向[3, 5]
        }

        // 接着遍历剩下的数组，如果和newInterval有交集，那么就合并到newInterval里面
        // 因为上面的遍历，现在剩下的数组的最大值都是大于newInterval的最小值的，
        // 如果要产生交集的话，应该要让数组的最小值 <= newInterval的最大值 例如[3,5] [4,8] 反例是[12,16] [4,8]
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // 把合并后的数组，存入到结果集中
        res[idx++] = newInterval;

        // 再把剩下的数组放入到结果集中
        while (i < len) {
            res[idx++] = intervals[i++];
        }

        // 合并后可能会有空的数组位置，使用拷贝来删除掉
        return Arrays.copyOf(res, idx);
    }
}
