package top200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    // 位运算
    // https://leetcode-cn.com/problems/missing-number/solution/diu-shi-de-shu-zi-by-leetcode-solution-naow/
    // 因为根据异或运算，两个形同的数如果进行异或运算，那么结果就是0，那么我们给定一个0，进行两次遍历然后进行异或操作，那么只出现过一次的数
    // 就会作为最后的结果出现
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {    // 注意第二遍有等号
            result ^= i;    // 给索引异或
        }

        return result;
    }

    // 用hash表，时间复杂度/空间复杂度O（n）
    public int missingNumber_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = -1;
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result = i;
                break;
            }
        }

        return result;
    }

    // 因为要排序，所以时间复杂度和空间复杂度不满足
    // 时间：O(nlogn)
    // 空间：O(logn) 排序是递归调用栈空间
    public int missingNumber_1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }
}
