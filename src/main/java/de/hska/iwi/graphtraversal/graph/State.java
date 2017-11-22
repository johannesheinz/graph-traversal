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
    private int[] distance;

    public State(int iteration, String[] collection, String current, String next, String[][] neighbors, int timer, int[] arrivals, int[] departures) {
        this.iteration = iteration;
        this.collection = collection;
        this.current = current;
        this.next = next;
        this.neighbors = neighbors;
        this.timer = timer;
        this.arrivals = arrivals;
        this.departures = departures;
        this.distance = null;
    }

    public State(int iteration, String[] collection, String current, String next, String[][] neighbors, int[] distance) {
        this.iteration = iteration;
        this.collection = collection;
        this.current = current;
        this.next = next;
        this.neighbors = neighbors;
        this.timer = 0;
        this.arrivals = null;
        this.departures = null;
        this.distance = distance;
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

    public int[] getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        // TODO: State toString
        return "State{}";
    }
}
