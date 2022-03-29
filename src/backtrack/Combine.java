package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(arr, res, list, k, 0);
        return res;
    }

    private void backTrack(int[] arr, List<List<Integer>> res, List<Integer> list, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < arr.length; i++) {
            int num = arr[i];
            list.add(num);

            backTrack(arr, res, list, k, i + 1);

            list.remove(list.size() - 1);
        }
    }
}
