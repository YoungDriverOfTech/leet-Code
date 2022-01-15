package offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ExchangeArray {

    // my solution: use double queue
    public int[] exchange(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                deque.addLast(num);
            } else {
                deque.addFirst(num);
            }
        }

        int[] newArray = new int[nums.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = deque.pop();
        }
        return newArray;
    }

    // double pointer
    public int[] exchange_1(int[] nums) {
        int i = 0, j = nums.length - 1, temp;

        while (i < j) {
            while (i < j && ((nums[i] & 1) == 1)) {
                i++;
            }

            while (i < j && ((nums[j] & 1) == 0)) {
                j--;
            }

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }


    public static void main(String[] args) {

        int[] param = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ExchangeArray().exchange(param)));
        System.out.println(Arrays.toString(new ExchangeArray().exchange_1(param)));
    }
}
