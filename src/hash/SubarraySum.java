package hash;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;   // 这里不进行break，是因为有可能后面紧跟的元素可能是0，如果break的话，那么就会减少一个应该被统计的数字
                }
            }
        }
        return result;
    }
}
