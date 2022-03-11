package linkedlist;

import java.util.LinkedList;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }


    // 把奇偶节点放入不同的list中进行遍历
    public ListNode oddEvenList_1(ListNode head) {
        if (head == null) {
            return head;
        }

        // 把奇数和偶数节点分开，放入到不同的list中
        LinkedList<ListNode> oddList = new LinkedList<>();
        LinkedList<ListNode> evenList = new LinkedList<>();
        boolean isOdd = true;
        ListNode temp = head;

        while (temp != null) {
            if (isOdd) {
                oddList.add(temp);
            } else {
                evenList.add(temp);
            }
            temp = temp.next;
            isOdd = !isOdd;
        }

        // 链接所有的奇数节点
        ListNode loopOdd = oddList.removeFirst();
        while (!oddList.isEmpty()) {
            ListNode nextNode = oddList.removeFirst();
            loopOdd.next = nextNode;

            // for next loop
            loopOdd = nextNode;
        }

        // now loopOdd is the last one odd node
        // 如果只有一个元素，那么evenList肯定是空，直接返回唯一的元素即可
        if (evenList.isEmpty()) {
            return head;
        }

        ListNode loopEven = evenList.removeFirst();
        loopOdd.next = loopEven;

        // 链接所有的偶数节点
        while (!evenList.isEmpty()) {
            ListNode nextNode = evenList.removeFirst();
            loopEven.next = nextNode;

            // for next loop
            loopEven = nextNode;
        }
        loopEven.next = null;
        return head;
    }
}
