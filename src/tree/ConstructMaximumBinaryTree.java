package tree;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int maxIndex = getMax(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);

        // 构建左右子数组
        int[] left = Arrays.copyOfRange(nums, 0, maxIndex);
        root.left = constructMaximumBinaryTree(left);

        int[] right = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        root.right = constructMaximumBinaryTree(right);

        return root;
    }

    private int getMax(int[] nums) {
        int max = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                index = i;
            }
            max = Math.max(max, num);
        }
        return index;
    }
}
