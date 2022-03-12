package linkedlist;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        // 维护两个链表，small和large，比x小的放入small，否则放入large
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;  // 指向小链表的最后一个节点
        ListNode large = largeHead;  // 指向大链表的最后一个节点

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        // 把large最后一个节点的next设为null,并且small最后一个节点的next指向large的首节点
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
