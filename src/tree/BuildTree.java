package tree;

import java.util.Arrays;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 先序遍历首元素是跟元素，找到这个跟元素，然后去中序遍历里面找到跟元素位置
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findRootIndex(rootVal, inorder);

        // 中序遍历根元素左边的索引全部是左子树，右边的全部是右子树，那么我们就构建出左右子树的数组，然后递归调用
        int[] preorderOfLeft = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
        int[] inorderOfLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        root.left = buildTree(preorderOfLeft, inorderOfLeft);

        int[] preorderOfRight = Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length);
        int[] inorderOfRight = Arrays.copyOfRange(inorder, 1 + rootIndex, inorder.length);
        root.right = buildTree(preorderOfRight, inorderOfRight);

        return root;
    }

    private int findRootIndex(int rootVal, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
