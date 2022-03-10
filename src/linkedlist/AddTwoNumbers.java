package linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 从首节点开始逐个节点相加，如果产生进位，那么在遍历到下个节点的时候加上
        int carry = 0;
        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode preNode = null;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            temp.val = sum % 10;    // 去本位的数值
            carry = sum / 10;       // 进位的数值赋值给carry

            // 下一次循环
            ListNode next = new ListNode();
            preNode = temp; // 记录当前节点，在最后退出，判断有无进位的时候如果无进位，那么需要把这个节点的下一个节点置成null
            temp.next = next;
            temp = temp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        // 如果最后一个出来，还存在进位的话，那么把进位的值也加入到链表中去
        if (carry != 0) {
            temp.val = carry;
        } else {
            preNode.next = null;
        }

        return result;
    }
}
