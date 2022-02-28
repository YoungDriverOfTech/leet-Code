package bs;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        return null;
    }

    // over time
    public List<Integer> countSmaller_1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num2 < num1) {
                    count++;
                }
            }

            list.add(count);
        }

        return list;
    }
}
