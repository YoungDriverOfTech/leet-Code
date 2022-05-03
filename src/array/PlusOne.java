package array;

import java.util.Arrays;

public class PlusOne {
    // https://leetcode-cn.com/problems/plus-one/solution/jia-yi-by-leetcode-solution-2hor/

    // 我们从后往前数，找到第一个不等于9的数字，比如336899， 此时找到了8
    // 然后把9加上1，从8开始后面的数字全部变成0
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // for case 9999, then we need create a new array of size n + 1, and set array[0] as 1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
    }
}
