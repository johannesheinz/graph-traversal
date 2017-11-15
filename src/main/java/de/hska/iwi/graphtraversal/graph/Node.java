package de.hska.iwi.graphtraversal.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int index;
    private String name;

    private boolean marked = false;
    private List<Node> neighbors = new ArrayList<>();

    public Node(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public void mark() {
        this.marked = true;
    }

    public boolean isMarked() {
        return marked;
    }

    public void addNeighbor(Node neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public List<Node> getNeighbors() {
        return this.neighbors;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
}
