package offer;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatNumber {

    // my solution
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer result = null;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], nums[i]);
            } else {
                result = nums[i];
                break;
            }
        }
        return result;

    }


    // better solution
    public int findRepeatNumber_1(int[] nums) {
        int[] arr = new int[nums.length]; // if no value assigned, all elements are 0
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++; // the value would larger than 1 if elements duplicated
            if(arr[nums[i]] > 1) return nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {

        System.out.println(new FindRepeatNumber().findRepeatNumber_1(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
