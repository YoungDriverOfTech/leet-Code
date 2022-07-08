package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /**
     * 回溯公式
     *
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     *
     * time O(n!)
     * 第一次可以选择3个，那么第二次可以选择两个，最后一次选择一个。
     * 那么算下来就是3*2*1
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(nums, list, res);

        return res;
    }

    private void backTrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backTrack(nums, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
