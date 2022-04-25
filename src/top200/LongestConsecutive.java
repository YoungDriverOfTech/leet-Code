package top200;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 每次都找最小的树，即比他更小的数是不存在的，从这个书开始遍历，一次次+1，直到找完所有的数
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 当前数字减1，在hash表里面找不到，所以当前数字是一个阶段性最小数字
            if (!set.contains(num - 1)) {
                int count = 1;
                int temp = 1;
                while (set.contains(num + temp)) {
                    count++;
                    temp++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
