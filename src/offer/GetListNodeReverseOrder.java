package offer;

import java.util.LinkedList;

public class GetListNodeReverseOrder {

    // my solution
    public ListNode getKthFromEnd(ListNode head, int k) {
        LinkedList<ListNode> nodeList = new LinkedList<>();
        while (head != null) {
            nodeList.addFirst(head);
            head = head.next;
        }

        if (nodeList.size() < k) {
            return null;
        }

        return nodeList.get(k - 1);
    }

    public ListNode getKthFromEnd_1(ListNode head, int k) {
        int n = 0;
        ListNode node = null;

        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }

        return node;
    }

    // double pointer
    public ListNode getKthFromEnd_3(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode kthFromEnd = new GetListNodeReverseOrder().getKthFromEnd_3(listNode1, 2);
        System.out.println();
    }
}
