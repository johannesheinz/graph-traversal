package de.hska.iwi.graphtraversal.graph;

public class State {

    private int iteration;
    private String[] collection;
    private String current;
    private String next;
    private String[][] neighbors;
    private int timer;
    private int[] arrivals;
    private int[] departures;

    public State() {
        // TODO: Remove default constructor
    }

    public State(int iteration, String[] collection, String current, String next, String[][] neighbors, int timer, int[] arrivals, int[] departures) {
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

    public String[] getCollection() {
        return collection;
    }

    public String getCurrent() {
        return current;
    }

    public String getNext() {
        return next;
    }

    public String[][] getNeighbors() {
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
