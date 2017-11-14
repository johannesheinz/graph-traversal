package de.hska.iwi.graphtraversal.output;

import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;

/**
 * Common methods for all exporters.
 */
public interface Exporter {

    void exportResults(List<State> states);
}
