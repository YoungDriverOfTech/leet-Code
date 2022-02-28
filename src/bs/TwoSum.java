package bs;

public class TwoSum {

    // my solution
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result; // 找到之后立即返回，不要等到循环结束在返回，否则超时
            }
        }

        return result;
    }
}
