package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 定义一个数组，用来存放每门课程的前置课程数量，并且统计前置课程的数量
        int[] input = new int[numCourses];
        for (int[] pre : prerequisites) {
            input[pre[0]]++;    // 因为索引0是当前课程的课程号，数组中出现几次，就说明该课程有几个前置课程
        }

        // 把前置课程为0的课程放入到一个队列中进行学习
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.add(i);
            }
        }

        // 学习每门课程，然后这门课程如果是其他课程的前置课程的话，那么其他课程的前置课程的数量需要减去1
        int count = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            // 学习完某一门课程了，那么count就加一
            int cur = queue.poll();
            result[count] = cur;
            count++;

            // 判断当前课程是不是其他课程的前置课程
            for (int[] pre : prerequisites) {
                // 如果当前课程的前置课程和cur课程相等，说明当前课程的前置数量需要减1
                if (pre[1] == cur) {
                    input[pre[0]]--;

                    // 如果当前课程的前置课程等于0的话，说明当前课程可以放入队列中进行学习了
                    if (input[pre[0]] == 0) {
                        queue.add(pre[0]);
                    }
                }
            }
        }

        return count == numCourses ? result : new int[0];
    }
}
