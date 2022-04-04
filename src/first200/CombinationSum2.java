package first200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        backTrack(candidates, target, res, list, 0, 0);

        return res;
    }

    private void backTrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 这里应该使用大于index，不能使用！=0，因为回溯的时候这个index会一直变化，所以要让i大于index 来保障唯一性
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }

            // 这里进行剪枝，如果和记起来已经比target大了，那么就不要循环了，直接退出即可，否则时间会超时
            sum += candidates[i];
            if (sum > target) {
                break;
            }
            list.add(candidates[i]);
            backTrack(candidates, target, res, list, i + 1, sum);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
