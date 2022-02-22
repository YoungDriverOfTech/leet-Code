package array;

public class MaxArea {
    // https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right -left);
            result = Math.max(result, area);

            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
