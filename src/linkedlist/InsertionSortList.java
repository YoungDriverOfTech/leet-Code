package linkedlist;

public class InsertionSortList {
    // https://leetcode-cn.com/problems/insertion-sort-list/solution/wei-tu-jie-147dui-lian-biao-jin-xing-cha-ru-pai-xu/
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 做成一个假节点，
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {   // 说明cur和他后面的节点是有序的，不用排序，往后推进即可
                cur = cur.next;
            } else {
                // 说明当前节点的后面节点 > 当前节点，那么就需要把后节点拿出来保存下来，然后从头再遍历一次，找到插入为止
                ListNode temp = cur.next;
                cur.next = cur.next.next;   // 删除后节点

                // 去找后节点应该插入的位置
                ListNode preNode = dummyNode; // 为什么要从dummy节点开始，因为原先头节点的位置可能成为插入位置
                while (preNode.next.val <= temp.val) {
                    preNode = preNode.next;
                }

                // 执行到这里说明preNode的下一个节点大于temp，peNode < temp < preNode.next
                // 那么就在这里执行插入
                temp.next = preNode.next;
                preNode.next = temp;
            }
        }

        return dummyNode.next;
    }
}
