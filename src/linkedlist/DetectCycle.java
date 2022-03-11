package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            }
            map.put(head, head);
            head = head.next;
        }

        return null;
    }
}
