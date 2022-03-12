package linkedlist;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 计算链表长度
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // 为什么需要dummy节点，因为被删除的节点有可能是第一个
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 找到需要被删除的节点，指针姐删除即可
        ListNode cur = dummy;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
