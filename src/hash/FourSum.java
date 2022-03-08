package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    // 二重循环 分别用来循环a和b，然后再使用双指针来循环c和d
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // 特殊判断
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return result;
        }

        Arrays.sort(nums);
        // 开始双重套双指针的循环
        for (int a = 0; a <= length - 4; a++) { // 因为需要4个一组进行动态list的填充，所以a循环的时候只能到倒数第四个元素为止
            if (a > 0 && nums[a - 1] == nums[a]) {
                continue;   // 保证a对应的元素确实是变换了的
            }

            for (int b = a + 1; b <= length - 3; b++) {
                if (b > a + 1 && nums[b - 1] == nums[b]) {
                    continue;   // 保证b对应的元素确实是变换了的
                }

                // 用双指针来循环c和d
                int c = b + 1;
                int d = length - 1;
                while (c < d) {
                    // 如果4个值的和 > target  --->   c右移
                    // 如果4个值的和 < target  --->   d左移
                    // 如果4个值的和 == target --->   把四个数组放入结果list， 然后c右移 d左移
                    if (nums[a] + nums[b] - target > -(nums[c]+nums[d])) {   // 因为测试用例会溢出，所以改写一些
                        d--;    // c++ 和d--不要弄错了
                    } else if (nums[a] + nums[b] - target <-(nums[c]+nums[d])) {
                        c++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        result.add(list);

                        // 确保c/d确实变了
                        while (c < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }

        return result;
    }
}
