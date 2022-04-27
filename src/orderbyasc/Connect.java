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
            Node dummy = new Node(0);
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
                cur = cur.next;
            }

            cur = dummy.next;
        }

        return root;
    }
}
