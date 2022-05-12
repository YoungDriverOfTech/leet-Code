package orderbyasc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {

    // https://leetcode-cn.com/problems/subsets-ii/solution/shu-ju-jie-gou-he-suan-fa-hui-su-suan-fa-jly8/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先对数组进行排序，这样相同的元素就会在一起，便于过滤
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    /**
     * @param nums     原始数组
     * @param res      需要返回的结果
     * @param tempList 当前路径上的元素
     * @param level    遍历到第几层
     */
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, int level) {
        //每条路径上所选择的元素组成的数组都是子集，所以都要添加到集合res中
        res.add(new LinkedList<>(tempList));
        //这里遍历的时候每次都有从之前选择元素的下一个开始，所以这里i的初始值是level
        for (int i = level; i < nums.length; i++) {
            //剪枝，过滤掉重复的
            // 比如 2（索引为1）这个元素，被遍历到的时候，会进行一次回溯 -> 会把这个2加入到元素res中
            // 然后从tempList中弹出，取出下一个2（索引为2），应为单个2已经在上一轮追加过了，所以这一轮就不在进行追加
            if (i != level && nums[i] == nums[i - 1])
                continue;
            //选择当前元素
            tempList.add(nums[i]);
            //递归到下一层
            backtrack(nums, res, tempList, i + 1);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }
}

