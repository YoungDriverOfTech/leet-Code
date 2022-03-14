package linkedlist;

public class SortList {
    // https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/
    public ListNode sortList(ListNode head) {
        // 使用归并排序
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到中点节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 把链表分割成两个子链表
        ListNode rightHead = slow.next;
        slow.next = null;

        // 把链表分割成最小单位，然后进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        // 所头尾节点，头节点用来返回首节点，尾节点用来遍历
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }
}
