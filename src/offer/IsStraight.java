package offer;

import java.util.HashSet;
import java.util.Set;

public class IsStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if (set.contains(num)) {
                return false;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }

        return max - min < 5;
    }
}
