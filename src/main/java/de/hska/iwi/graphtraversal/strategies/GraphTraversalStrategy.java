package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;

public abstract class GraphTraversalStrategy {

    final Graph graph;

    public GraphTraversalStrategy(Graph graph) {
        this.graph = graph;
    }

    public abstract List<State> traverseGraph(Node startNode);

    public abstract String getName();
}
