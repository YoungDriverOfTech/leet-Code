package offer;

public class DeleteNode {

    // my solution
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }

        return null;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode listNode = new DeleteNode().deleteNode(null, 4);
        System.out.println();
        System.out.println();
    }
}
