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

    // 递归
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next); // 取到的最后一个节点

        // 反转操作
        // 递归到最后一层，现在p = 5， head是4
        // 4 -> 5.  反转操作需要  null <- 4 <- 5
        head.next.next = head; // 5的next指针指向了4
        head.next = null; // 4的指针指向了空

        // 现在总体的情况变成了
        // 1 -> 2 -> 3 -> 4 <- 5

        // 然后把p返回给上一轮，处理节点3和4
        return p;
    }

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
