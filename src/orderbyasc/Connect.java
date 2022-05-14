package orderbyasc;

import dfs.Node;

public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node cur = root;
        while (cur != null) {
            // create a dummyNode that always points at the first node at next layer
            Node dummy = new Node(0);   // dummy.next始终指向下一层首先出现的节点
            Node pre = dummy;   // every layer is a linkedlist and pre is the head node of linkedlist

            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;    // dummy also points at cur.left
                    pre = pre.next; // pre now is cur.left
                }

                if (cur.right != null) {
                    pre.next = cur.right;   // connect cur'left and right
                    pre = pre.next; // pre now is cur.right
                }

                //for the root node, it's to quit this loop
                cur = cur.next; // 第二层从2移动到3
            }

            cur = dummy.next;   // cur节点移动到下一层
        }

        return root;
    }
}
