package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends GraphTraversalStrategy {

    private Stack<Node> stack = new Stack<>();
    private int iteration = 0;

    private List<Node>[] neighbors;
    private int[] arrivals;
    private int[] departures;

    public DepthFirstSearch(Graph graph) {
        super(graph);
    }

    private void addState(List<State> log, Node current, Node next, int timer) {

        // TODO: Deep copy: by value not by reference!

        // TODO: Don't save useless information

        log.add(new State(
                iteration++,
                this.stack,
                current,
                next,
                this.neighbors,
                timer,
                this.arrivals,
                this.departures
        ));
    }

    @Override
    public List<State> traverseGraph(Node startNode) {

        List<State> log = new ArrayList<>();

        neighbors = new List[graph.getNodeCount()];
        arrivals = new int[graph.getNodeCount()];
        departures = new int[graph.getNodeCount()];

        // TODO: Deep copy: by value not by reference!

        stack.push(startNode);
        startNode.mark();
        neighbors[startNode.getIndex()] = startNode.getNeighbors();
        int timer = 1;
        arrivals[startNode.getIndex()] = timer;

        // Save initial state of the graph
        addState(log, null, null, timer);

        while (!stack.empty()) {

            Node current = stack.peek();

            // TODO: Is this statement right here?
            neighbors[current.getIndex()] = current.getNeighbors();

            if (neighbors[current.getIndex()].isEmpty()) {

                // TODO: Choose v2 from neighbors of v
                Node next = neighbors[current.getIndex()].get(0);

                // TODO: Remove v2 from v's neighbors
                neighbors[current.getIndex()].remove(next);

                if (!next.isMarked()) {
                    stack.push(next);
                    next.mark();
                    neighbors[next.getIndex()] = next.getNeighbors();
                    departures[next.getIndex()] = ++timer;
                }

                // Add state of the graph after this iteration
                addState(log, current, next, timer);

            } else {
                stack.pop();
                departures[current.getIndex()] = ++timer;

                // Add state of the graph after this iteration
                addState(log, current, null, timer);
            }
        }
        return log;
    }

    @Override
    public String getName() {
        return "Depth-first search";
    }
}
