package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends GraphTraversalStrategy {

    private static final String DFS_NAME = "Depth-first search";

    private Stack<Node> stack = new Stack<>();
    private int timer;
    private int[] arrivals;
    private int[] departures;

    public DepthFirstSearch(Graph graph) {

        super(graph, DFS_NAME);

        // DFS collection
        this.stack = new Stack<>();

        this.timer = 1;
        this.arrivals = new int[graph.getNodeCount()];
        this.departures = new int[graph.getNodeCount()];
    }

    @Override
    public List<State> traverseGraph(Node startNode) {

        stack.push(startNode);
        startNode.mark();
        neighbors[startNode.getIndex()] = startNode.getNeighbors();
        arrivals[startNode.getIndex()] = timer;

        // Save initial state of the graph
        addState(null, null);

        while (!stack.empty()) {

            Node current = stack.peek();
            neighbors[current.getIndex()] = current.getNeighbors();

            if (!neighbors[current.getIndex()].isEmpty()) {

                // Choose next from neighbors of current
                Node next = neighbors[current.getIndex()].get(0);

                // Remove next from current's neighbors
                neighbors[current.getIndex()].remove(next);

                if (!next.isMarked()) {
                    stack.push(next);
                    next.mark();
                    neighbors[next.getIndex()] = next.getNeighbors();
                    arrivals[next.getIndex()] = ++timer;
                }

                // Add state of the graph after this iteration
                addState(current, next);

            } else {
                stack.pop();
                departures[current.getIndex()] = ++timer;

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
                        deepCopyCollection(stack),
                        current != null ? current.getName() : null,
                        next != null ? next.getName() : null,
                        getNeighborsForLog(),
                        timer,
                        Arrays.copyOf(arrivals, graph.getNodeCount()),
                        Arrays.copyOf(departures, graph.getNodeCount())
                )
        );
    }
}
