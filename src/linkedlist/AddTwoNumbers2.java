package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers2 {

    // 也可以使用栈来做，把l1,l2的全部元素都压入栈中，然后一个一个弹出来计算他们的和
    // https://leetcode-cn.com/problems/add-two-numbers-ii/solution/liang-shu-xiang-jia-ii-by-leetcode-solution/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 把两个链表转换为两个list
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        // 计算节点和，并且把所计算的节点放入一个list中
        int index1 = list1.size() - 1;
        int index2 = list2.size() - 1;
        int carry = 0;
        List<ListNode> resultList = new ArrayList<>();
        while (index1 >= 0 || index2 >= 0) {
            int num1 = index1 < 0 ? 0 : list1.get(index1);
            int num2 = index2 < 0 ? 0 : list2.get(index2);
            int sum = num1 + num2 + carry;

            resultList.add(new ListNode(sum % 10));
            carry = sum / 10;   // 保存进位

            // 变化索引
            index1--;
            index2--;
        }

        // 最后有进位的话，需要把进位也做成一个节点放进去
        if (carry != 0) {
            resultList.add(new ListNode(carry));
        }

        // 处理节点之间的关系
        for (int i = resultList.size() - 2; i >= 0; i--) {
            ListNode pre = resultList.get(i + 1);
            ListNode cur = resultList.get(i);
            pre.next = cur;
        }

        return resultList.get(resultList.size() - 1);
    }
}
