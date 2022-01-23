package offer;

import java.util.Arrays;

/**
 * 1. 两种遍历方式，先用前序遍历的第一个元素（根元素），到中序遍历里面求根元素的索引（即1）
 *  preorder = [3,9,20,15,7],
 *  inorder =  [9,3,15,20,7]
 *
 * 2. 分别对原来的这两个树组进行复制，然后进行递归调用
 *  因为要对root节点的左右子树进行赋值操作，所以要进行
 *  左子树前序遍历拷贝，左子树中序遍历拷贝 & 右子树前序遍历拷贝，右子树中序遍历拷贝
 *
 *  左子树前序遍历拷贝：[9]
 *  左子树中序遍历拷贝：[9]
 *
 *  右子树前序遍历拷贝：[20,15,7]
 *  右子树中序遍历拷贝：[15,20,7]
 *
 *  位置的确定，需要根据中序遍历根元素的索引的位置
 *
 * */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 构造根结点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        // 然后把根结点的左子树和右子树构造起来

        // 应该把左子树的前序遍历和中序遍历的组数组当作参数传入
        // 获得根结点中序遍历的索引
        int rootIndex = getRootIndex(preorder, inorder);
        int[] leftSubTreePreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] leftSubTreeInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        root.left = buildTree(leftSubTreePreorder, leftSubTreeInorder);

        // 应该把右子树的前序遍历和中序遍历的组数组当作参数传入
        int[] rightSubTreePreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] rightSubTreeInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        root.right = buildTree(rightSubTreePreorder, rightSubTreeInorder);

        return root;
    }

    private int getRootIndex(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
