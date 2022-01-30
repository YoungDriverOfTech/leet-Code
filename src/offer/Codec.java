package offer;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        Codec codec = new Codec();
        String serializeNode = codec.serialize(node1);
        System.out.println(serializeNode);

        TreeNode result = codec.deserialize(serializeNode);
        System.out.println();
    }
}
