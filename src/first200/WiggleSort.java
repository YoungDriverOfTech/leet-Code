package first200;

import java.util.Arrays;

public class WiggleSort {
    // 偶数的情况
    // 1 1 1 4 5 6
    //     l     r
    // 1 6

    // 1 1 1 4 5 6
    //   l     r
    // 1 6 1 5

    // 1 1 1 4 5 6
    // l     r
    // 1 6 1 5 1 4

    // 奇数的情况
    // 1 1 4 5 6
    //     l   r
    // 4 6

    // 1 1 4 5 6
    //   l   r
    // 4 6 1 5

    // 1 1 4 5 6
    // l   r
    // 4 6 1 5 1

    // https://leetcode-cn.com/problems/wiggle-sort-ii/solution/by-germs-4kz9/
    public void wiggleSort(int[] nums) {
        int[] copyNum = nums.clone();
        Arrays.sort(copyNum);
        int left = (nums.length - 1) / 2;     // 从中间开始插入，即前半段的最大值
        int right = nums.length - 1;      // 从末尾开始插入，即后半段的最大值

        // l和r都从末尾开始(即从最大值开始)，是为了防止出现元素相同的情况
        // 因为在copy的中间部分，可能存在相等的多个元素，例[1,1,2,1,2,2,1] ——》[1,1,1,1,2,2,2]
        // 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果.
        // 由此可知在自然排序中前段序列的最大值一定小于后端序列的最大值
        for (int i = 0; i < nums.length - 1; i += 2) {  // 这块小于nums.length - 1，如果不这么写nums[i + 1]会空指针
            nums[i] = copyNum[left--];
            nums[i + 1] = copyNum[right--];
        }

        if (nums.length % 2 == 1) {
            nums[nums.length - 1] = copyNum[left];
        }
    }
}
