package linkedlist;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
                temp.next = null;
                temp = pre.next;
                continue;
            }

            temp = temp.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
