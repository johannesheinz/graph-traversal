package de.hska.iwi.graphtraversal.input;

public class NodeNotFoundException extends RuntimeException {

    public NodeNotFoundException(final String nodeName) {
        super("There is no node with the name '" + nodeName + "'.");
    }
}
