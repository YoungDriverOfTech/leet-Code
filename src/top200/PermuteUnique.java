package top200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        backTrack(nums, res, list, used);

        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 已经被使用过的数字不能被重复使用
            if (used[i]) {
                continue;
            }

            // 剪枝条件的原因
            // https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;

            backTrack(nums, res, list, used);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 2}));
    }
}
