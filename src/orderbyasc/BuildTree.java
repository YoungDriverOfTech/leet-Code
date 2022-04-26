package orderbyasc;

import dfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    // https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 被每个元素放入map，以便快速取出
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 把后续遍历的数组放入全局变量中，方便操作
        this.postorder = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 因为后续遍历最后一个是根元素，所以取出构造跟节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 构造左右子树
        int rootIndex = map.get(rootVal);

        // 左子树参数解释
        // 第二个参数，因为传的是索引，而根索引已被使用，所以传根索引前一个索引
        // 第四个参数，需要传postStart + 中序遍历从头到跟节点索引的长度（因为中序和后续遍历都是做节点开始，所以长度可以划分出左子树）
        //   长度=节点索引 - inStart，计算出来的是长度，因此在长度的基础上，需要再减去1
        root.left = buildTree(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);

        // 左子树参数解释
        // 第三个参数，有上面的第三个参数解释可知，这块需要的是紧跟着上面的后面一个索引，所以把减1去掉就行
        // 第四个参数，因为跟节点是最后一个参数，已经在构造 跟节点的时候被使用了，所以要减1
        root.right = buildTree(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);

        return root;
    }
}
