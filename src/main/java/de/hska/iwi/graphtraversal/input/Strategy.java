package de.hska.iwi.graphtraversal.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Strategy {
    @JsonProperty("dfs")
    DFS("Depth-first search"),
    @JsonProperty("bfs")
    BFS("Breadth-first search");

    private final String name;

    Strategy(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
