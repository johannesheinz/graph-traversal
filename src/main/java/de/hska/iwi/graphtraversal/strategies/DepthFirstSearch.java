package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch implements GraphTraversalStrategy {

    private Stack<Node> stack = new Stack<>();
    private int iteration = 0;
    private List<State> states = new ArrayList<>();

    private List<Node>[] neighbors;
    private int[] arrivals;
    private int[] departures;

    private void addState(Node current, Node next, int timer) {

        // TODO: Deep copy: by value not by reference!

        // TODO: Don't save useless information

        states.add(new State(
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
    public List<State> traverseGraph(Graph graph, Node startNode) {

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
        addState(null, null, timer);

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
                addState(current, next, timer);

            } else {
                stack.pop();
                departures[current.getIndex()] = ++timer;

                // Add state of the graph after this iteration
                addState(current, null, timer);
            }
        }
        return this.states;
    }
}
