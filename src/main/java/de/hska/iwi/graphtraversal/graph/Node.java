package de.hska.iwi.graphtraversal.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Node> neighbors = new ArrayList<>();
    private boolean marked;

    public void mark() {
        this.marked = true;
    }

    public boolean isMarked() {
        return marked;
    }

    public void getNeighbor(Node neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public int getIndex() {

        // TODO: Node index

        return 0;
    }
}
