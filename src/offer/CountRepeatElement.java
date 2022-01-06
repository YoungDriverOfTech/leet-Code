package offer;

import java.util.HashMap;
import java.util.Map;

public class CountRepeatElement {

    // my solution
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums[0] > target || target > nums[nums.length - 1]) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = countMap.getOrDefault(nums[i], 0) + 1;
            countMap.put(nums[i], temp);
            if (nums[i] > target) {
                break;
            }
        }
        return countMap.getOrDefault(target, 0);
    }


    // better solution
    // find first element that equals target in left side, and count number
    public int search_1(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] >= target) {
                right = middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        while (left < nums.length && nums[left] == target) {
            left++;
            count++;
        }
        return count;
    }




    public static void main(String[] args) {
        System.out.println(new CountRepeatElement().search_1(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(new CountRepeatElement().search_1(new int[]{5,7,7,8,8,10}, 0));
    }
}
