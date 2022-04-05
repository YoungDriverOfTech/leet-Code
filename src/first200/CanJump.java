package first200;

public class CanJump {
    // https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
    public boolean canJump(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);

                if (right >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
