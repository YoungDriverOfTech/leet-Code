package orderbyasc;

import linkedlist.ListNode;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode left = dummyHead;
        ListNode right = head;
        dummyHead.next = head;

        while (right != null) {
            ListNode preNode = null;
            int preVal = right.val;

            while (right != null && preVal == right.val) {
                preNode = right;
                right = right.next;
            }

            left.next = preNode;
            left = left.next;
        }

        return dummyHead.next;
    }
}
