package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    // 方法1


    public TreeNode buildTree_1(int[] preorder, int[] inorder) {

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

    // 方法2
    private Map<Integer, Integer> map = new HashMap();
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 因为先序遍历的首位就是跟节点，所以取出跟节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 构建左右节点

        // 取出跟节点在中序遍历中的索引位置
        int rootIndex = map.get(rootVal);
        root.left = buildTree(preStart + 1, preStart + rootIndex - inStart, inStart, rootIndex - 1);
        root.right = buildTree(preStart + rootIndex - inStart + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}
