package first200;

public class Jump {
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
}
