package demo;

import java.util.*;

public class Solution {

    public int solution(int M, int N) {
        // write your code in Java SE 8

        /**
         * Here is my solution, Because XOR operation is exactly same with [ ^ ] operation. I just use [ ^ ] Operation to
         * replace the XOR operation, and do a traversal from M to N.
         *
         * Because 0 ^ number(any number) equals number. So I initialize result variable as 0, and let result to XOR every
         * number from M to N. Then I can get the final result.
         *
         * But my solution can not resolve a border case (0, 1000000000) Because of TIMEOUT ERROR (Killed. Hard limit reached: 5.000 sec.),
         * and my code like this
         *
         *      int result = 0;
         *      for (int i = M; i <= N; i++) {
         *          result = result ^ i;
         *      }
         *      return result;
         *
         * Then I decided to use double pointer to reduce the time complexity, and it also doesn't work.
         * I tested some cases. It seems like (0, 680000000) is my solution limitation.
         * */

        int left = M;
        int right = N;
        int result = 0;

        while (left <= right) {
            result = result ^ left;
            if (left == right) {
                break;
            }

            result = result ^ right;

            left++;
            right--;
        }
        return result;
    }

    public String[] solution(int capacity, String[] commands) {
        if (capacity == 0 || commands == null || commands.length == 0) {
            return new String[0];
        }

        // using linkedlist to mimic queue
        LinkedList<String> queue = new LinkedList<>();
        String[] result = new String[commands.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if ("TAKE".equals(command)) {
                // Returns first element when queue is not empty, otherwise return ""
                if (!queue.isEmpty()) {
                    result[i] = queue.removeFirst();
                } else {
                    result[i] = "";
                }
            } else if ("SIZE".equals(command)) {
                result[i] = queue.size() + "";
            } else {
                // Adding true to result if queue' size lesser than capacity, otherwise add false
                // Adding second part of command into queue if queue' size lesser than capacity
                if (queue.size() < capacity) {
                    queue.addLast(command.substring(6));
                    result[i] = "true";
                } else {
                    result[i] = "false";
                }
            }
        }
        return result;
    }

    public int[] solution_1(int windowSize, int[] numbers) {

        int[] result = new int[numbers.length - windowSize + 1];

        // Using a stack to store maximum value in desc order
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= numbers.length - windowSize; i++) {

            // only put maximum value into stack, if there is a number > stack.peek(), then pop the
            // stack element and push the new maximum value
            int j = i;
            while (j + windowSize <= numbers.length) {
                if (stack.isEmpty()) {
                    stack.push(numbers[j]);
                } else if (stack.peek() < numbers[j]) {
                    stack.pop();
                    stack.push(numbers[j]);
                }
                j++;
            }

            result[i] = stack.pop();
        }
        return result;
    }

    public int[] solution_4(int []numbers, int target) {

        // First, I need this numbers arrary sorted in asc order
        Arrays.sort(numbers);
        int[] result = new int[2];

        // Using double pointer to figure this problem out, define left and right pointer, sum up numbers[left] and number[right] and narrow distance between left and right until we find sum equals target
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = numbers[left];
                result[1] = numbers[right];
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
