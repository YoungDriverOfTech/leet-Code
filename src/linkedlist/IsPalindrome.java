package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindrome {

    // 双指针
    public boolean isPalindrome_1(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 使用双指针，左右逼近中心，判断他们的值是否相等
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 反转后半部分链表，然后比较是否是回文节点
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 使用快慢指针，找到位与中间的节点，然后反转后面那一部分的节点顺序
        ListNode firstHalfEnd = findSecondHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 比较回文节点
        boolean result = true;
        ListNode temp = head;
        while (result && secondHalfStart != null) {
            if (temp.val != secondHalfStart.val) {
                result = false;
            }
            temp = temp.next;
            secondHalfStart = secondHalfStart.next;
        }

        // 把后半部分再反转回来
        reverseList(firstHalfEnd.next);
        return result;
    }

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

    // 使用快慢指针来遍历节点，慢得一步步走，快的两步两步走，当快的到达尾部时，慢的正好走一半
    private ListNode findSecondHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
