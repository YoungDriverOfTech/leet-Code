package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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


    private int[] preorder;
    private int[] inorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        // 复制给全局变量，方便操作
        this.preorder = preorder;
        this.inorder = inorder;

        // 我们把中序遍历的数组存入一个map，key=节点值 value=节点索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int preStart, int preEnd, int inStart, int inEnd) {

        // 如果数组的开始索引大于了结束索引，返回null节点即可
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 因为先序遍历的头节点就是根节点，所以我们那出头元素来构造跟节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 找到跟节点在中序遍历中的索引位置
        int rootIndex = map.get(rootVal);

        root.left = helper(preStart + 1, preStart + (rootIndex - inStart), inStart, rootIndex - 1);
        root.right = helper(preStart + (rootIndex - inStart) + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}
