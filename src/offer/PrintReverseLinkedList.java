package offer;

import java.util.Arrays;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class PrintReverseLinkedList {

    // my solution
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        PrintReverseLinkedList test = new PrintReverseLinkedList();
        System.out.println(Arrays.toString(test.reversePrint(node1)));
    }
}
