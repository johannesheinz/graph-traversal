package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;

public interface GraphTraversalStrategy {

    List<State> traverseGraph(Graph graph, Node startNode);
}
