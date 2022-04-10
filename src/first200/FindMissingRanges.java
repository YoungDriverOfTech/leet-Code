package first200;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * */
public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int start = lower;

        for (int i = 0; i < nums.length; i++) {
            // 如果开头比nums[i]小，说明有缺失的元素
            if (start < nums[i]) {
                if (start == nums[i] - 1) {
                    result.add("" + start);
                } else {
                    result.add(start + "->" + (nums[i] - 1));
                }

                start = nums[i] + 1;
            }
        }

        // 说明就只剩下最后一个元素没有被添加
        if (start == upper) {
            result.add("" + start);
        } else {
            result.add(start + "->" + upper);
        }
        return result;
    }
}
