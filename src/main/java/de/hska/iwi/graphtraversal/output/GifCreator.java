package de.hska.iwi.graphtraversal.output;

import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;

/**
 * Exports the results as an animated *.gif file.
 */
public class GifCreator extends Exporter {

    public GifCreator(String filename) {
        super(filename);
    }

    @Override
    public void exportResults(List<State> log) {

    }
}
