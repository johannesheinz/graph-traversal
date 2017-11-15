package de.hska.iwi.graphtraversal.input;

public class InvalidGraphConfigurationException extends RuntimeException {

    public InvalidGraphConfigurationException() {
        super("The configuration of the graph is invalid. Please read the documentation.");
    }

    public InvalidGraphConfigurationException(String message) {
        super(message);
    }
}
