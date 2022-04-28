package orderbyasc;

public class CloneGraph {
    // https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/

    /**
     *
     *      public Node cloneGraph(Node node) {
     *         if (node == null) {
     *             return node;
     *         }
     *
     *         // 用map来存储已经被复制过的节点
     *         Map<Node, Node> map = new HashMap<>();
     *         map.put(node, new Node(node.val, new ArrayList<Node>()));
     *
     *         // 把当前的节点，放入队列中进行遍历复制
     *         // 加入当前节点为1，其邻居是2，3，4
     *         Queue<Node> queue = new LinkedList<>();
     *         queue.add(node);
     *
     *         while (!queue.isEmpty()) {
     *             // 现在拿到的是1
     *             Node beforeCopy = queue.poll();
     *
     *             // 遍历1的邻居节点，然后复制邻居节点 2,3,4
     *             for (int i = 0; i < beforeCopy.neighbors.size(); i++) {
     *                 Node beforeCopyNeighbor = beforeCopy.neighbors.get(i);  // 代表2，3，4
     *
     *                 // 如果该邻居节点不在map中，那么就进行复制
     *                 // 复制出来的2'，3'，4'应该被放入复制后的1'的neighbors中去
     *                 if (!map.containsKey(beforeCopyNeighbor)) {
     *                     Node afterCopyNeighbor = new Node(beforeCopyNeighbor.val, new ArrayList<Node>());   // 代表2‘，3’，4‘
     *                     map.put(beforeCopyNeighbor, afterCopyNeighbor);
     *                     queue.add(beforeCopyNeighbor);
     *                 }
     *
     *                 // 如果邻居节点存在于map中，那么应该把这个节点取出，放到beforeCopy的复制后节点的neighbors中
     *                 map.get(beforeCopy).neighbors.add(map.get(beforeCopyNeighbor));
     *             }
     *         }
     *
     *         return map.get(node);
     *     }
     * */
}
