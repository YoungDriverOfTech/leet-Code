package dfs;

import linkedlist.ListNode;

public class SortedListToBST {
    // https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/comments/
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 使用快慢指针法，找到链表的终点，当作树的跟节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;    // 用来记录中点节点的前一个节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        // 现在slow是中点，将作为树的根节点，然后把链表断开成两段，递归调用，做成子树即可
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        ListNode rightHead = slow.next;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);

        return root;
    }
}
