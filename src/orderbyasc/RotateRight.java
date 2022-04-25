package orderbyasc;

import linkedlist.ListNode;

public class RotateRight {

    // https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-tu-jie-lian-biao-zu-ku33/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        // 先统计出链表的长度，并且找到最后的尾节点
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 再找到旋转后的新的尾节点，这个节点即原来的len-k个节点
        ListNode newTail = head;
        k = k % len;    // 因为k可能比len大
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // 现在知道了新旧尾节点，那么让新尾节点.next = null, 旧的尾节点.next = head即可
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
}
