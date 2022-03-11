package linkedlist;

public class ReverseBetween {
    // https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定义两个节点a和b，a是需要反转节点之前的节点，b是首个需要反转的节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode aNode = dummy;
        ListNode bNode = dummy.next;

        // 找到首个需要反转的节点
        int step = 0;
        for (int i = 0; i < left - 1; i++) {
            aNode = aNode.next;
            bNode = bNode.next;
        }

        // 把b后面的节点挨个儿放入a节点后面
        for (int i = 0; i < right - left; i++) {
            ListNode temp = bNode.next; // 先把b后面要被删除的节点拿出来
            bNode.next = bNode.next.next;   // 然后把b节点后面的节点都给接起来

            // 把被删除的节点，放到a节点的后面,并且接上b节点
            temp.next = aNode.next;
            aNode.next = temp;

        }
        return dummy.next;
    }
}
