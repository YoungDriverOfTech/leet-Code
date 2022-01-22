package offer;

public class LowestCommonAncestor_2 {
    // explanation: https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) {
            return null; // 1.
        }

        if(left == null) {
            return right; // 3.
        }

        if(right == null) {
            return left; // 4.
        }

        return root; // 2. if(left != null and right != null)
    }




    public static void main(String[] args) {
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_1 = new TreeNode(1);
        node_3.left = node_5;
        node_3.right = node_1;


        TreeNode node_6 = new TreeNode(6);
        TreeNode node_2 = new TreeNode(2);
        node_5.left = node_6;
        node_5.right = node_2;

        TreeNode node_0 = new TreeNode(0);
        TreeNode node_8 = new TreeNode(8);
        node_1.left = node_0;
        node_1.right =node_8;

        TreeNode node_7 = new TreeNode(7);
        TreeNode node_4 = new TreeNode(4);
        node_2.left = node_7;
        node_2.right = node_4;

        System.out.println(new LowestCommonAncestor_2().lowestCommonAncestor(node_3, node_5, node_4));
    }
}
