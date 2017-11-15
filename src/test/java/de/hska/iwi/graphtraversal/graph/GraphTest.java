package de.hska.iwi.graphtraversal.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void getNodeByName() throws Exception {
    }

    @Test
    public void getNodeCount() throws Exception {

        List<String> edges = Arrays.asList(
                " a-b",
                " a - b",
                " a -b ",
                " a----b ",
                " a<->b",
                " a<->b ",
                "a<-->b",
                "a->b",
                "a<-b",
                "a <-b",
                "a<- b",
                "a <- b",
                " a <-b ",
                " a<- b ",
                " a <- b ",
                "a->b",
                "a ->b",
                "a-> b",
                "a -> b",
                " a ->b ",
                " a-> b ",
                " a -> b ",
                " a-->b ",
                " a--->b ",
                " a-------->b ",
                " a>b ",
                " a<b ",
                " a<>b "
                );

        for (String edge : edges) {
            edge = edge.trim();
            String[] split1 = edge.split("<(-)+>");
            String[] split2 = edge.split("(-)+>");
            String[] split3 = edge.split("<(-)+");
            System.out.println("    " + edge);
            System.out.println(split1.length + "  " + Arrays.toString(split1));
            System.out.println(split2.length + "  " + Arrays.toString(split2));
            System.out.println(split3.length + "  " + Arrays.toString(split3));
            System.out.println("-------------------------------------");

            if(split1.length == 2) {

            } else if (split2.length == 2) {

            } else if (split3.length == 2) {

            }
        }
    }
}