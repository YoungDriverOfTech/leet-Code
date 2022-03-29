package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(candidates, target, res, list, 0, 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int sum, int begin) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        // 注意从begin 开始，是为了预防重复的路径查找
        for (int i = begin; i < candidates.length; i++) {
            int num = candidates[i];
            list.add(num);
            sum += num;


            backTrack(candidates, target, res, list, sum, i);

            list.remove(list.size() - 1);
            sum -= num;
        }
    }
}
