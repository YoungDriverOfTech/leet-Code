package stack;

import java.util.Iterator;
import java.util.LinkedList;

public class NestedIterator implements Iterator<Integer> {
// -------------------------------- 非本题代码
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
// --------------------------------
// https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/fu-xue-ming-zhu-xiang-jie-ti-yi-shu-li-d-n4qa/
/**
    private Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new LinkedList<>();
        // 展开最外层
        for (NestedInteger nexted : nestedList) {
            deque.offer(nexted);
        }
    }

    @Override
    public Integer next() {
        return deque.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!deque.isEmpty()) {
            if (deque.peekFirst().isInteger()) { // 如果第一个元素是int，那么就返回true
                return true;
            }

            // 如果第一个元素是个nestedInteger，那么就把这个东西给他展开，然后再给他放到队列的前面
            // 首元素出队
            List<NestedInteger> list = deque.poll().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                deque.addFirst(list.get(i));
            }
        }

        return false;
    }
*/
}
