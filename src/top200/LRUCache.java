package top200;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/lru-cache/solution/zui-jin-mian-zi-jie-yi-mian-peng-dao-lia-1t15/
class LRUCache {
    // 因为要满足增删查都是O1复杂度，所以我们需要维护两个数据结构，一个map，用来查询，一个双链表，用来增删
    // 增删的时候要同时对map进行更新
    private Map<Integer, Node> map;
    private DoubleLink cache;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLink();
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 因为get方法使用到节点了，所以需要调整双链表的LRU，调用put方法来调整
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            // 如果已经存在了，那么就需要把这个节点更新一下，把这个节点放到双链表头部，表示最近被用过
            cache.delete(map.get(key));
            cache.addFirst(newNode);

            // 这里map需要重新put一下，因为有可能key一样，值不一样
            map.put(key, newNode);
        } else {
            // 如果已经到了边界值，那么就需要移除最不常用的节点，即双链表尾部节点
            if (map.size() == cap) {
                int k = cache.deleteLast(); // 注意这里获取的是被删除的节点的key，不要和要插入的key搞混了
                map.remove(k);
            }

            map.put(key, newNode);
            cache.addFirst(newNode);
        }
    }
}

/*
这个类是双链表，用来满足头尾节点的O(1)增删
头节点代表最近被用过的
为节点就是LRU Cache
*/
class DoubleLink {
    // 这两个节点是固定死的，用来对数据进行增删的时候会被用到
    public Node head;
    public Node tail;

    public DoubleLink() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.pre = head;
    }

    // 次节点应该被添加到head之后，head和tail是永远不能动的
    public void addFirst(Node node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    // 删除某个节点，并且返回其key
    public int delete(Node node) {
        int key = node.key;

        node.pre.next = node.next;
        node.next.pre = node.pre;


        return key;
    }

    // 删除最后一个节点
    public int deleteLast() {
        // 如果没有节点的话，就返回-1
        if (head.next == tail) {
            return -1;
        }

        // 有节点的话，就必须要删除掉tail的上一个节点了
        return delete(tail.pre);
    }
}

/*
这个类是节点类，用来存放具体数据
*/
class Node {
    public int key;
    public int val;
    public Node pre;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
