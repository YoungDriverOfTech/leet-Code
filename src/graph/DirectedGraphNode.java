package graph;

import java.util.List;

public class DirectedGraphNode {

    private int no;

    // 指向了这些节点
    private List<DirectedGraphNode> adjNodes;

    public DirectedGraphNode(int no, List<DirectedGraphNode> adjNodes) {
        this.no = no;
        this.adjNodes = adjNodes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<DirectedGraphNode> getAdjNodes() {
        return adjNodes;
    }

    public void setAdjNodes(List<DirectedGraphNode> adjNodes) {
        this.adjNodes = adjNodes;
    }
}
