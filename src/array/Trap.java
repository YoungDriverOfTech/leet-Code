package array;

public class Trap {
    // https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left <= right) { // 这里必须加上等于号
            // 左边最大值小于右边，能装多少水就取决于左边的最大值
            if (leftMax < rightMax) {
                if (leftMax > height[left]) {
                    result += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    result += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return result;
    }
}
