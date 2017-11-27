package de.hska.iwi.graphtraversal.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GraphConfiguration {

    @JsonProperty
    private boolean directed;

    @JsonProperty
    private List<String> edges;

    @JsonProperty
    private List<String> nodes;

    @JsonProperty
    private List<Output> output;

    @JsonProperty
    private String startNode;

    @JsonProperty
    private Strategy strategy;


    public boolean isDirected() {
        return directed;
    }

    public List<String> getEdges() {
        return edges;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public List<Output> getOutput() {
        return output;
    }

    public String getStartNode() {
        return startNode;
    }

    public Strategy getStrategy() {
        return strategy;
    }


    @Override
    public String toString() {
        return "directed? " + directed +
                ", edges=" + edges +
                ", nodes=" + nodes +
                ", output=" + output +
                ", startNode='" + startNode + '\'' +
                ", strategy=" + strategy;
    }
}
