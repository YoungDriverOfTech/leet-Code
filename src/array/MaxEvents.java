package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {
    // 这是一道典型的扫描算法题。由于每个时间点最多参加一个会议，我们可以从1开始遍历所有时间。
    // [[1,2],[1,2],[2,3],[3,4]]  -> 首先按照会议的开始时间进行排序
    // 然后我们开始第一天开始，先遍历数组看看有那些会议是第一天能参加的，发现第一个和第二个是能参加的。
    // 因为一天只能参加一个会议，那么我们参加那个呢？ -> 会议时间结束早的那个，因为那样的话，晚结束的那个会议，可以使用后面的天数去参加
    // 那么两个会议中，那个结束早，我们怎么知道呢？  使用小根堆

    // 那这个举例子[[1,2],[1,2],[2,3],[3,4]]
    // 第一天： 有两个会议可以参加，因为会议开始时间是1，所以把两个会议的结束时间放入优先队列
    //         然后看看优先队列里面有没有比第一天还早的会，如果有的话就直接remove掉，因为会议结束时间比今天还早，所以已经无法参加了
    //         然后选择一个会议参加，这个会议是今天开始且结束时间最早的那个会议，参加完之后pq里面就只剩下2
    // 第一天： 有一个会议能参加，把结束时间让入pq中，那么bq目前的状态就是2，3
    //         然后选择一个会议参加，参加了会议2，目前bq只剩下会议3
    // 第三天： 有一个会议能参加，把结束时间让入pq中，那么bq目前的状态就是3，3
    //         然后选择一个会议参加，参加了会议3，目前bq只剩下会议4
    // 第四天： events里面已经没有会议了，但是bq里面还有一个会议可以参加，那么参加完以后bq为空，就退出循环。
    // 时间复杂度 O(Tlogn) T为天数，因为优先队列插入删除都是O(logn)所以相乘起来
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int index = 0;
        int day = 1;    // 从第一天开始往后面一天一天推
        int result = 0;
        while (index < events.length || !queue.isEmpty()) {
            while (index < events.length && day == events[index][0]) {
                queue.offer(events[index][1]);
                index++;
            }

            while (!queue.isEmpty() && queue.peek() < day) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                queue.poll();
                result++;
            }

            day++;
        }
        return result;
    }
}
