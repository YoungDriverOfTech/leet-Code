package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(nums, res, list, 0);

        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> list, int begin) {
        res.add(new ArrayList<Integer>(list));
        if (list.size() == nums.length) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            int num = nums[i];
            list.add(num);

            backTrack(nums, res, list, i + 1);

            list.remove(list.size() - 1);
        }
    }
}
