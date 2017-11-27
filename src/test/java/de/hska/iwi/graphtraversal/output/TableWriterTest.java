package de.hska.iwi.graphtraversal.output;

import de.hska.iwi.graphtraversal.graph.State;
import de.hska.iwi.graphtraversal.input.Strategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TableWriterTest {

    TableWriter writer;

    @Before
    public void setUp() throws Exception {
        this.writer = new TableWriter("test", Strategy.DFS);
    }

    @Test
    public void exportEmptyLog() throws Exception {
        List<State> log = new ArrayList<>();
        //log.add(new State());
        //log.add(new State());
        writer.exportResults(log);
    }

}
