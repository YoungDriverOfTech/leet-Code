package hash;

import java.util.Arrays;

public class ContainsDuplicate {

    // 也可以用hash来做
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
