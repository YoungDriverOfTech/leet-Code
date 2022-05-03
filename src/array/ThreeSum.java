package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            // 因为已经经过排序，所以一旦某个元素大于0了，其后面的元素都会大于0，不满足3数之和想加等于0的条件
            if (nums[i] > 0) {
                break;
            }

            // remove duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    // find duplicate elements and remove them
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 追加完一次合适的解后，要把左右指针进行移动
                    left++;     // 注意，不要忘记移动指针
                    right--;

                } else if (currentSum > 0) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }

        return result;
    }


    // my solution: over time
    public List<List<Integer>> threeSum_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);

        while (left < right) {
            if ((nums[left] + nums[left + 1] + nums[right]) > 0) {
                right--;
            } else if ((nums[left] + nums[left + 1] + nums[right]) < 0) {
                left++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[left + 1]);
                list.add(nums[right]);
                resultList.add(list);
            }
        }

        return resultList;
    }
}
