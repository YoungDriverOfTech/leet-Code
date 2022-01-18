package offer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    // solution 1: hashTable, copy a new list and rearrange their relationship
    public Node copyRandomList_1(Node head) {
        if (head == null) {
            return head;
        }

        // cope old list into map just as Map<oldNode, newNode>, no need to consider random node
        Map<Node, Node> map = new HashMap<>();
        for (Node node = head; node != null; node = node.next) {
            map.put(node, new Node(node.val));
        }

        // rearrange copied node as a new list
        for (Node node = head; node != null; node = node.next) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }

        return map.get(head);
    }


    // solution 2: hashTable, copy a new list and rearrange their relationship
    public Node copyRandomList_2(Node head) {
        if (head == null) {
            return head;
        }

        // cope old node and paste behind the old node, just like a -> a' -> b -> b'
        for (Node cur = head, newNode = null; cur != null; cur = cur.next.next) {
            newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
        }

        // rearrange copied node random node
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) { // need to judge random node existing, otherwise error happens
                cur.next.random = cur.random.next;
            }
        }

        // split list into tow list, like: [a -> b -> c], [a' -> b' -> c']
        Node newNode = head.next;
        for (Node cur = head; cur != null && cur.next != null;) {
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }

        return newNode;
    }


}
