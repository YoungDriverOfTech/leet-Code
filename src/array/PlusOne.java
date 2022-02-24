package array;

import java.util.Arrays;

public class PlusOne {
    // https://leetcode-cn.com/problems/plus-one/solution/jia-yi-by-leetcode-solution-2hor/
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
