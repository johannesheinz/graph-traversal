package de.hska.iwi.graphtraversal.output;

import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;

/**
 * Exports the results as an animated *.gif file.
 *
 * Using the "Animated GIF Writer" by Elliot Kroo
 * Source: http://elliot.kroo.net/software/java/GifSequenceWriter
 * License: CC BY 3.0 (http://creativecommons.org/licenses/by/3.0)
 */
public class GifCreator extends Exporter {

    public GifCreator(String filename) {
        super(filename);
    }

    @Override
    public void exportResults(List<State> log) {

    }
}
