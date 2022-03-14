package linkedlist;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 定义四个节点
        // pre 反转节点之前的一个节点
        // start 反转节点的头节点
        // end 反转节点的尾节点
        // next 反转节点之后的一个节点

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 找到end的位置
            for (int i = 0; i < k && end != null; i++) {    // 为了防止end出现空指针
                end = end.next;
            }

            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转, ps 不要忘了这句
            if(end==null){
                break;
            }

            // 找到next节点的位置，并且断开end和next之间的连接
            ListNode nextNode = end.next;
            end.next = null;

            // 找到start的位置，并且从start位置开始反转链表,并且把pre和反转后的链表接上
            ListNode start = pre.next;
            pre.next = reverse(start);

            // 因为上面的反转过程，start节点因为被反转到了最后面，所以把反转后的结果和后面的链表接续起来，需要start节点来接续
            start.next = nextNode;

            // 为下一次循环移动指针
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }

        // 反转一个链表，并且返回反转后的头节点
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;

        while (cur != null) {
            // 记录下下一个节点
            next = cur.next;
            cur.next = pre;

            // 为下一次循环移动指针位置
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
