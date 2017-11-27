package de.hska.iwi.graphtraversal.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Output {
    @JsonProperty("table") TABLE,
    @JsonProperty("gif") GIF
}
