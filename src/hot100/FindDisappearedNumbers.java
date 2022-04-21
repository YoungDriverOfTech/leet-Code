package hot100;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    // https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/java-yuan-di-ha-xi-si-lu-qing-xi-dai-ma-a12yd/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 先遍历一次数组，因为题意说明数字都是【1，n】之间，所以我们把对应的数字放到对应的索引上面
        // 排完序以后，那么没有对应上的数字就是可以数字，我们在遍历一次取出即可
        int len = nums.length;
        int index = 0;
        while (index < len) {
            // 先找到数字原本应该在的地方,如果原本应该在的地方值和现在的值相等，说明不需要交换
            int targetIndex = nums[index] - 1;
            if (nums[targetIndex] == nums[index]) {
                index++;
                continue;
            }

            // 如果不想等那么就进行交换
            int temp = nums[targetIndex];
            nums[targetIndex] = nums[index];
            nums[index] = temp;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
