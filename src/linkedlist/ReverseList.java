package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {

    // 遍历
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归 todo


    // list
    public ListNode reverseList_1(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            ListNode pre = list.get(i + 1);
            ListNode cur = list.get(i);
            pre.next = cur;
            cur.next = null;
        }

        return list.get(list.size() - 1);
    }

}
