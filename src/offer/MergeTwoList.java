package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoList {

    // my solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        // transfer linkedNodeList into arrayList and merger them
        List<Integer> node1List = new ArrayList<>();
        while (l1 != null) {
            node1List.add(l1.val);
            l1 = l1.next;
        }

        List<Integer> node2List = new ArrayList<>();
        while (l2 != null) {
            node2List.add(l2.val);
            l2 = l2.next;
        }
        node1List.addAll(node2List);
        Collections.sort(node1List);

        // generate a new LinkedNodeList
        ListNode resultNode = new ListNode(node1List.get(0));
        ListNode tempNode = resultNode;
        for (int i = 1; i < node1List.size(); i++) {
            tempNode.next = new ListNode(node1List.get(i));
            tempNode = tempNode.next;
        }

        return resultNode;
    }

    // better solution, double pointer
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode(0);
        ListNode currentNode = resultNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = l1 != null ? l1 : l2;
        return resultNode.next;
    }

    // better solution, recursion
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(4);
        node1_1.next = node1_2;
        node1_2.next = node1_3;

        ListNode node2_1 = new ListNode(1);
        ListNode node2_2 = new ListNode(3);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;

        ListNode resultNode = new MergeTwoList().mergeTwoLists(node1_1, node2_1);
        System.out.println();

    }
}
