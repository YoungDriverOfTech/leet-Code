package offer;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    // my solution
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        for (int i = list.size() - 1 ; i >= 0; i--) {
            ListNode latterNode = list.get(i);
            ListNode previousNode;
            if (i - 1 >= 0) {
                previousNode = list.get(i - 1);
                latterNode.next = previousNode;
            } else {
                latterNode.next = null;
            }
        }
        return list.get(list.size() - 1);
    }

    // better solution (double pointer)
    public ListNode reverseList_2(ListNode head) {
        ListNode pre = null, cur = head, next = null;

        while (cur != null) {
            ListNode tempNode = cur.next;

            // reverse is done
            cur.next = pre;

            // preparation for next loop
            pre = cur;
            cur = tempNode;
        }
        return pre;
    }

    // better solution ()
    public ListNode reverseList_3(ListNode head) {
        ListNode pre = null, cur = head, next = null;

        while (cur != null) {
            ListNode tempNode = cur.next;

            // reverse is done
            cur.next = pre;

            // preparation for next loop
            pre = cur;
            cur = tempNode;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

//        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        new ReverseLinkedList().reverseList(null);
        System.out.println();

    }
}
