package linkedlist;

import top200.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveNthFromEnd {
    // 统计长度
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

    // 栈
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 双指针（一次遍历）
    // 想让快指针走n个节点，然后让慢指针从头节点开始走，这样快指针到最后时，慢指针刚好走到了目标节点上
    // 这时如果慢指针能指向目标节点的前驱节点的话，那么就可以进行删除操作了，我们让慢指针开始遍历的时候，指向一个哑节点
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
