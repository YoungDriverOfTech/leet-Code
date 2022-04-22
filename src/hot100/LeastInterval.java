package hot100;

public class LeastInterval {
    // https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
    public int leastInterval(char[] tasks, int n) {
        // 新建数组，统计每个字符出现的次数
        int[] arr = new int[26];
        for (char ch : tasks) {
            arr[ch - 'A']++;
        }


        // 遍历arr，找到出现频率最高的那个字符的出现次数
        int maxTimes = 0;
        for (int time : arr) {
            maxTimes = Math.max(maxTimes, time);
        }

        // 例子["A","A","A","B","B","B" "A"]
        // 可以被划分为
        // A B Del
        // A B Del
        // A B Del
        // A
        // 那么就有最大次数的三组数据 + 最后一个A
        // (maxTimes - 1) * (n + 1) + remains
        // remains怎么算呢，因为最后一行填不满的一定是出现次数最多的那个字符，如果不是的话，早就被填入到Del中了
        // 我们只需要遍历arr，判断每个字符出现的次数和maxTimes相等的话，那么给最后的结果+1就行
        int res = (maxTimes - 1) * (n + 1);
        for (int time : arr) {
            if (time == maxTimes) {
                res++;
            }
        }

        // 如果没有出现重复的任务的话，那么根据上面的公式算出来的结果是偏小的
        // 那么我们需要返回tasks的length，因为没有重复任务，所以不可能有空档
        return Math.max(res, tasks.length);
    }
}
