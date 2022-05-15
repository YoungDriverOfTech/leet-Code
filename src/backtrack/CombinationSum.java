package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
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

    // https://leetcode.cn/problems/combination-sum/solution/hui-su-shi-jian-chao-guo-9992-si-lu-qing-jzka/
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum_1(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    private void backtrack(int[] candidates, int remains, List<Integer> path, int start){
        if(remains == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > remains)
                return;

            if(i > 0 && candidates[i] == candidates[i-1])   continue;
            //[2,2,3,5]

            path.add(candidates[i]);

            backtrack(candidates, remains - candidates[i], path, i);

            path.remove(path.size() - 1);
        }
    }
}
