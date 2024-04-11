package graph;

import java.util.*;

public class DirectedGraph {

    private final List<DirectedGraphNode> graphNodes;

    public DirectedGraph(List<DirectedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public List<DirectedGraphNode> topologicalSort() {
        List<DirectedGraphNode> result = new ArrayList<>();

        // step 1 计算每个图节点的入度，用map维护。 Key：当前图节点 Value：入度值
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graphNodes) {
            // 入度：谁指向我, node 会指向他的所有的邻接节点
            for (DirectedGraphNode adjNode : node.getAdjNodes()) {
                if (!inDegreeMap.containsKey(adjNode)) {
                    inDegreeMap.put(adjNode, 1);
                } else {
                    Integer integer = inDegreeMap.get(adjNode);
                    inDegreeMap.put(adjNode, integer + 1);
                }
            }
        }

        // step 2 将入度为0的节点入队
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graphNodes) {
            // 判断每个节点是不是在map中，不在map中的一定是入度为0。因为map中的节点，入度至少是1
            if (!inDegreeMap.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        // step 3 BFS
        while (!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            // 把当前的cur从图中擦掉
            for (DirectedGraphNode adj : cur.getAdjNodes()) {
                // 邻接节点入度-1
                int inDegree = inDegreeMap.get(adj);
                int updatedInDegree = inDegree - 1;
                inDegreeMap.put(adj, updatedInDegree);

                // 如果入度为0，则入队
                if (updatedInDegree == 0) {
                    queue.offer(adj);
                    result.add(adj);
                }
            }
        }

        return result;
    }
}
