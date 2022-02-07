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

        // 这一步不能少，因为得记录下头节点，下面的循环要使用
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // 条件不能写成 headA != headB
        while (pointerA != pointerB) {

            // 因为要对pointer进行操作，所以使用pointerA.next, 然后头节点也需要记录下来，方便遍历的时候使用
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;
    }
}
