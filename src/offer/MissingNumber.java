package offer;

public class MissingNumber {

    // my solution
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftValue = nums[i], rightValue = nums[nums.length - 1 - i];
            if (leftValue + rightValue != nums.length) {
                if (leftValue != i) {
                    return i;
                }

                if (rightValue != nums.length - i) {
                    return nums.length - i;
                }
            } else {
                if (nums.length == 2) {
                    return 1;
                }
            }
        }
        return -1;
    }


    // binary search better solution
    // https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
    // this is explanation link
    public int missingNumber_1(int[] nums) {
        int start = 0, end = nums.length - 1, middle = (start + end) / 2;

        while (start <= end) {
            if (nums[middle] != middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber_1(new int[]{2,0}));
    }
}
