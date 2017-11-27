package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;
import de.hska.iwi.graphtraversal.input.Strategy;

import java.util.*;

/**
 *
 */
public class BreadthFirstSearch extends GraphTraversalStrategy {

    private static final Strategy STRATEGY = Strategy.BFS;

    private Queue<Node> queue;
    private int[] distance;

    public BreadthFirstSearch(Graph graph) {

        super(graph, STRATEGY);

        this.queue = new LinkedList<>();
        this.distance = new int[graph.getNodeCount()];
        Arrays.fill(distance, -1);
    }

    @Override
    public List<State> traverseGraph(Node startNode) {

        queue.add(startNode);
        startNode.mark();

        neighbors[startNode.getIndex()] = startNode.getNeighbors();
        distance[startNode.getIndex()] = 0;

        // Save initial state of the graph
        addState(null, null);

        while (!queue.isEmpty()) {

            Node current = queue.element();
            neighbors[current.getIndex()] = current.getNeighbors();

            if (!neighbors[current.getIndex()].isEmpty()) {

                // Choose next from neighbors of current
                Node next = neighbors[current.getIndex()].get(0);

                // Remove next from current's neighbors
                neighbors[current.getIndex()].remove(next);

                if (!next.isMarked()) {
                    queue.add(next);
                    next.mark();
                    neighbors[next.getIndex()] = next.getNeighbors();
                    distance[next.getIndex()] = distance[current.getIndex()] + 1;
                }

                // Add state of the graph after this iteration
                addState(current, next);

            } else {
                queue.remove();

                // Add state of the graph after this iteration
                addState(current, null);
            }
        }
        return log;
    }

    @Override
    void addState(Node current, Node next) {

        log.add(
                new State(
                        iteration++,
                        deepCopyCollection(queue),
                        current != null ? current.getName() : null,
                        next != null ? next.getName() : null,
                        getNeighborsForLog(),
                        Arrays.copyOf(distance, graph.getNodeCount())
                )
        );
    }
}
