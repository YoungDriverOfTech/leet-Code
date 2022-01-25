package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // my solution
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer countValue = map.getOrDefault(num, 0);
            map.put(num, ++countValue);
        }

        int halfEven = nums.length / 2;
        int result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > halfEven) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    // sort
    /**
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为(n/2)的元素（下标从 0 开始）一定是众数。
     * 0 1 2 3 4 5 6  元素奇数个，一半是3.5, 假如最小的元素0是众数，那么第四个位置上就是0
     * 0 1 2 3 4 5    元素偶数个，一半是3, 假如最小的元素0是众数，那么第四个位置上就是0
     * */
    public int majorityElement_1(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // vote
    /**
     * 树组中众数一定多余非众数，可以定义一个计数器，如果出现众数则+1，出现非众数则减1，最后计数器肯定是正的
     * */
    public int majorityElement_2(int[] nums) {

        int register = 0;
        int majority = 0;
        for (int num : nums) {
            if (register == 0) {
                majority = num;
            }

            register += majority == num ? 1 : -1;
        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
    }
}
