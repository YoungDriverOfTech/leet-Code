package linkedlist;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (true) {
            // 找到最小的节点，然后赋值给minNode
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                // 如果没有这个判断，那么下面的lists[i].val会出错
                if (lists[i] == null) {
                    continue;
                }

                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }

            // 退出循环条件，因为lists[minIndex] = lists[minIndex].next;会把指针一直往后移，所以上面的循环会不满足条件，直接不执行，那么minIndex就不会变化
            if (minIndex == -1) {
                break;
            }

            // 把最小的节点接到dummy后面去
            tail.next = minNode;
            tail = tail.next;

            // 修改最小节点指针（往后移动）
            lists[minIndex] = lists[minIndex].next;
        }

        return dummy.next;
    }
}
