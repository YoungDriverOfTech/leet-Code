package top200;

public class Jump {

    // time: O(n) / space: O(1)
    public int jump(int[] nums) {
        int maxPosition = 0;    //  遍历每个元素可以到达的最远距离位置
        int step = 0;   // 跳跃步数
        int end = 0;    // 每跳一步所能达到的最远距离

        // 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);

            if (i == end) {
                end = maxPosition;
                step++;
            }
        }

        return step;
    }

    // time: O(n * n) / space: O(1)
    // 先找到最后一个索引，然后从左往右数，看哪个元素能直接到达最后一个索引，如果到了，那么step++，记当前索引是p1
    // 然后把再从左往右找，看哪个索引能直接p1，一直到开头的元素
    public int jump_1(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {

            for (int i = 0; i < position; i++) {
                int maxReach = i + nums[i];
                if (maxReach >= position) {
                    step++;
                    position = i;
                }
            }
        }

        return step;
    }
}
