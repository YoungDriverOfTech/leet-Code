package order;

public class HIndex {
    // 题意解释
    // https://leetcode-cn.com/problems/h-index/solution/er-fen-cai-lun-wen-pian-shu-java-by-liwe-zoh7/
    // citations = [3,0,6,1,5], H指数就是一个临界值（论文数量），超过这个临界值，往后的每一篇论文的引用数量都会大于这个临界值
    // 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
    // 现有5片论文，那我们让h依次增长，找出满足情况的即可
    // 假定h等于1 -> 数组中比h大的有4篇论文 -> 不满足，因为在他的5篇论文中，每一篇论文被引用的次数超过1次的，总共有4篇
    // 假定h等于2 -> 数组中比h大的有3篇论文 -> 不满足，因为在他的5篇论文中，每一篇论文被引用的次数超过2次的，总共有3篇
    // 假定h等于3 -> 数组中比h大的有3篇论文 -> 满足，因为在他的5篇论文中，每一篇论文被引用的次数超过3次的，总共有3篇
    // 假定h等于4 -> 数组中比h大的有2篇论文 -> 不满足，因为在他的5篇论文中，每一篇论文被引用的次数超过4次的，总共有2篇
    // 假定h等于5 -> 数组中比h大的有2篇论文 -> 不满足，因为在他的5篇论文中，每一篇论文被引用的次数超过5次的，总共有2篇

    // If there are several possible values for h, the maximum one is taken as the h-index. 所以我们要取最大的那个值

    // time O(NlogN)
    // space O(1)
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;

        while (left < right) {
            int mid = (left + right + 1) / 2;   // left right mid 都代表论文的数量
            int count = 0;  // 代表某人全部论文中，每一篇的引用次数大于等于mid的总数量

            // 统计count的数量
            for (int num : citations) {
                if (num >= mid) {
                    count++;
                }
            }

            // 二分查找
            if (mid <= count) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
