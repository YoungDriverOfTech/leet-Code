package orderbyasc;

import linkedlist.ListNode;

public class DeleteDuplicates {
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/java-duo-jie-fa-hao-li-jie-dai-ma-qing-x-tcex/
    public ListNode deleteDuplicates(ListNode head) {
        // 因为给定链表的数值是递增的，可以利用这条性质来判断是否存在重复节点
        if (head == null || head.next == null) {
            return head;
        }

        // 做一个假的节点当作头节点
        ListNode dummyHead = new ListNode(0);
        ListNode left = dummyHead;
        ListNode right = head;
        left.next = right;

        // 统计每两个不同数值节点之间的距离，如果超过1了，就需要进行删除
        while (right != null) {
            int count = 0;
            int preVal = right.val;
            ListNode preNode = null;

            // 右节点从自身开始遍历，遍历前保存自身。知道碰到值不一样的节点
            while (right != null && preVal == right.val) {
                count++;
                preNode = right;
                right = right.next;
            }

            // left目前是dummyHead节点，即 left preRight right
            if (count == 1) {
                left.next = preNode;
                left = left.next;
            } else {
                // 如果count不是1，说明出现了重复的元素，因为right会跑到第一个和之前的值不同的节点
                // 那么要删除掉重复的值，需要让left的下一个节点直接指向right
                left.next = right;
            }
        }

        return dummyHead.next;
    }
}
