package de.hska.iwi.graphtraversal.graph;

import java.util.Collection;
import java.util.List;

public class State {

    private int iteration;
    private Collection<Node> collection;
    private Node current;
    private Node next;
    private List[] neighbors;
    private int timer;
    private int[] arrivals;
    private int[] departures;

    public State() {
        // TODO: Remove default constructor
    }

    public State(int iteration, Collection<Node> collection, Node current, Node next, List[] neighbors, int timer, int[] arrivals, int[] departures) {
        this.iteration = iteration;
        this.collection = collection;
        this.current = current;
        this.next = next;
        this.neighbors = neighbors;
        this.timer = timer;
        this.arrivals = arrivals;
        this.departures = departures;
    }

    public int getIteration() {
        return iteration;
    }

    public Collection<Node> getCollection() {
        return collection;
    }

    public Node getCurrent() {
        return current;
    }

    public Node getNext() {
        return next;
    }

    public List[] getNeighbors() {
        return neighbors;
    }

    public int getTimer() {
        return timer;
    }

    public int[] getArrivals() {
        return arrivals;
    }

    public int[] getDepartures() {
        return departures;
    }

    @Override
    public String toString() {
        // TODO: State toString
        return "State{}";
    }
}
