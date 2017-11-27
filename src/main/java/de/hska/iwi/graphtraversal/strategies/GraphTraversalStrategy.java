package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;
import de.hska.iwi.graphtraversal.input.Strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class GraphTraversalStrategy {

    final Graph graph;
    final Strategy strategy;

    int iteration;
    List<Node>[] neighbors;

    List<State> log;

    @SuppressWarnings("unchecked")
    GraphTraversalStrategy(final Graph graph, final Strategy strategy) {

        this.graph = graph;
        this.strategy = strategy;

        this.iteration = 0;
        this.neighbors = (List<Node>[]) new List[graph.getNodeCount()];

        this.log = new ArrayList<>();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public abstract List<State> traverseGraph(Node startNode);

    abstract void addState(Node current, Node next);

    String[] deepCopyCollection(Collection<Node> collection) {

        Node[] tmp = new Node[collection.size()];
        String[] data = new String[collection.size()];

        tmp = collection.toArray(tmp);
        for (int i = 0; i < collection.size(); i++) {
            data[i] = tmp[i].getName();
        }

        return data;
    }

    String[][] getNeighborsForLog() {

        String[][] neighborsForLog = new String[graph.getNodeCount()][];

        for (int i = 0; i < graph.getNodeCount(); i++) {
            if (neighbors[i] != null) {
                neighborsForLog[i] = new String[neighbors[i].size()];
                for (int j = 0; j < neighbors[i].size(); j++) {
                    neighborsForLog[i][j] = neighbors[i].get(j).getName();
                }
            }
        }
        return neighborsForLog;
    }
}
