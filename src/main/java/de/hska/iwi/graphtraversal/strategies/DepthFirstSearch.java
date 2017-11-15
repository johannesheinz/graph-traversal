package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends GraphTraversalStrategy {

    private Stack<Node> stack = new Stack<>();
    private int iteration = 0;

    private List<Node>[] neighbors;
    private int[] arrivals;
    private int[] departures;
    List<State> log;

    public DepthFirstSearch(Graph graph) {
        super(graph);

        neighbors = new List[graph.getNodeCount()];
        arrivals = new int[graph.getNodeCount()];
        departures = new int[graph.getNodeCount()];

        log = new ArrayList<>();
    }

    private void addState(Node current, Node next, int timer) {

        Node[] tmp = new Node[stack.size()];
        String[] data = new String[stack.size()];

        tmp = stack.toArray(tmp);
        for (int i = 0; i < stack.size(); i++) {
            data[i] = tmp[i].getName();
        }

        String[][] neighborList = new String[graph.getNodeCount()][];
        for (int i = 0; i < graph.getNodeCount(); i++) {
            if (neighbors[i] != null) {
                neighborList[i] = new String[neighbors[i].size()];
                for (int j = 0; j < neighbors[i].size(); j++) {
                    neighborList[i][j] = neighbors[i].get(j).getName();
                }
            }
        }

        log.add(
                new State(
                        iteration++,
                        data,
                        current != null ? current.getName() : null,
                        next != null ? next.getName() : null,
                        neighborList,
                        timer,
                        Arrays.copyOf(arrivals, graph.getNodeCount()),
                        Arrays.copyOf(departures, graph.getNodeCount())
                )
        );
    }

    @Override
    public List<State> traverseGraph(Node startNode) {

        stack.push(startNode);
        startNode.mark();
        neighbors[startNode.getIndex()] = startNode.getNeighbors();
        int timer = 1;
        arrivals[startNode.getIndex()] = timer;

        // Save initial state of the graph
        addState(null, null, timer);

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
                addState(current, next, timer);

            } else {
                stack.pop();
                departures[current.getIndex()] = ++timer;

                // Add state of the graph after this iteration
                addState(current, null, timer);
            }
        }
        return log;
    }

    @Override
    public String getName() {
        return "Depth-first search";
    }
}
