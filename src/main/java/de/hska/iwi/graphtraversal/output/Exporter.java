package de.hska.iwi.graphtraversal.output;

import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;

/**
 * Common methods for all exporters.
 */
public abstract class Exporter {

    String filename;

    public Exporter(String filename) {
        this.filename = filename;
    }

    public abstract void exportResults(List<State> log);
}
