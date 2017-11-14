package de.hska.iwi.graphtraversal.graph;

import java.util.Collection;
import java.util.List;

public class State {

    public State() {
    }

    public State(int iteration, Collection<Node> collection, Node current, Node next, List[] neighbors, int timer, int[] arrivals, int[] departures) {

    }

    @Override
    public String toString() {
        return "State{}";
    }
}
