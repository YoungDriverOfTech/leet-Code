package demo;

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
}
