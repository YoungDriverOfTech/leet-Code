package linkedlist;

public class SwapPairs {

    // 递归调用
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs(three);

        return two;
    }
}
