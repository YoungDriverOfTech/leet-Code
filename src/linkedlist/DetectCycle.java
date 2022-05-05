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

    // https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/by-zz1998-ho3m/
    // 双指针法
    // 假设链表从头到环链表的距离为a（不包括环的起点），环的长度为b -> 每次走到环的起点需要的步数是 a + nb (n = 0, 1, 2,...)
    // 加入快慢指针在环内首次相遇了，他们分别走过的路程是 快指针：a + 2nb    慢指针：a + nb。 那么最终快慢指针走过的步数差就是2n倍的环的长度
    // 当快慢指针首次相遇的时候，两指针的走过距离差值是一个环的长度，即b。 又因为快指针速度是满指针的两倍，所以快指针走过的路程是慢指针的两倍
    // 当他们的路程差距是一个b的时候，意味着相遇的时候快指针走了2b的长度， 慢指针走了b的长度。
    // 因为 【每次走到环的起点需要的步数是 a + nb (n = 0, 1, 2,...)】，b现在已经走了b的长度，在需要走a个长度就能到达环的开头
    // 那么此时我们让快指针从头开始一步一步走，走上a步就能到达环。
    public ListNode detectCycle_1(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
