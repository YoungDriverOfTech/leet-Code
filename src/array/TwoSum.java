package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {i, hashMap.get(target - nums[i])};
            }

            hashMap.put(nums[i], i);
        }
        return new int[0];
    }


    // my solution
    public int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // 遍历数组，转换成map<index, value>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        // 找到相加之和等于target的两个数
        int[] valueArray = new int[2];
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);  // 因为下面的算法需要数组有序，所以先进性排序

        // when array elements are all positive
        while (left < nums.length && right >= 0) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                valueArray[0] = nums[left];
                valueArray[1] = nums[right];
                break;
            }
        }

        // 在map中找到值和valueArray值一样的entry，然后把key取出，装进结果数组里面，进行返回
        int[] result = new int[2];
        int index = 0;
        for (int value : valueArray) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != null && entry.getValue() == value) {
                    Integer key = entry.getKey();
                    result[index] = key;
                    map.put(key, null);
                    index++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{150, 24, 79, 50, 88, 345, 3}, 200)));
    }
}
