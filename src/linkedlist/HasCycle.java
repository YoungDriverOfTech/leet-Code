package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class HasCycle {

    // hash table
    public boolean hasCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, head);
            head = head.next;
        }

        return false;
    }

    // 快满指针
    // https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
    public boolean hasCycle_1(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
