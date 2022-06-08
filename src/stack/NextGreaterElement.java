package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    // https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 因为1是2的子集，我们只需要遍历2，然后记录下2中每个元素的下个元素，存入map，再遍历一次1，取出来就行
        int len1 = nums1.length;
        int len2 = nums2.length;

        // 用来存放下一个更大的值
        Map<Integer, Integer> map = new HashMap<>();

        // 用来存放遍历数组的值（单调递减栈）
        Stack<Integer> stack = new Stack<>();

        for (int i = len2 - 1; i >= 0; i--) {
            int num = nums2[i];

            // 当前元素的后面一个元素，如果比当前元素小的话，那么就把栈里面的元素弹出来，当前元素对应的答案是-1
            // 如果大于当前元素的话，那么这个循环就不执行了，说明栈顶的元素是当前元素对应的答案值
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        // 遍历nums1,然后从map中取出来对应的数字即可
        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
