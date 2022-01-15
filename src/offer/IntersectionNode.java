package offer;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {

    // hashSet
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode tempNode = headA;

        while (tempNode != null) {
            hashSet.add(tempNode);
            tempNode = tempNode.next;
        }

        tempNode = headB;
        while (tempNode != null) {
            if (hashSet.contains(tempNode)) {
                return tempNode;
            }

            tempNode = tempNode.next;
        }
        return null;
    }

    // doublePointer
    // explanation: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/liang-ge-lian-biao-de-di-yi-ge-gong-gong-pzbs/
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;
    }
}
