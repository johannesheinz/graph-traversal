package de.hska.iwi.graphtraversal.graph;

import de.hska.iwi.graphtraversal.input.GraphConfiguration;
import de.hska.iwi.graphtraversal.input.InvalidGraphConfigurationException;
import de.hska.iwi.graphtraversal.input.NodeNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    private final boolean directed;
    private List<Node> nodes = new ArrayList<>();

    public Graph(GraphConfiguration configuration) {

        this.directed = configuration.isDirected();

        int index = 0;
        for (String nodeName : configuration.getNodes()) {
            this.nodes.add(new Node(index++, nodeName));
        }

        for (String edge : configuration.getEdges()) {
            parseEdge(edge);
        }
    }

    /**
     * Parses a given edge of the graph if it matches the specified patterns and the mode of this graph.
     *
     * @param edge One edge is this graph
     * @throws InvalidGraphConfigurationException if the given edge cannot be parsed.
     */
    private void parseEdge(String edge) throws InvalidGraphConfigurationException {

        if (directed) {
            if (!(edge.contains("->") || edge.contains("<-"))) {
                throw new InvalidGraphConfigurationException("Directed graphs must contain arrows ('->' or '<-') in the edge definitions.");
            }

            edge = edge.trim();
            String[] split1 = edge.split("<(-)+>");
            String[] split2 = edge.split("(-)+>");
            String[] split3 = edge.split("<(-)+");

            if (split1.length == 2) {
                Node node1 = getNodeByName(split1[0]);
                Node node2 = getNodeByName(split1[1]);

                // node1 <-> node2
                node1.addNeighbor(node2);
                node2.addNeighbor(node1);

            } else if (split2.length == 2) {
                Node node1 = getNodeByName(split2[0]);
                Node node2 = getNodeByName(split2[1]);

                // node1 -> node2
                node1.addNeighbor(node2);

            } else if (split3.length == 2) {
                Node node1 = getNodeByName(split3[0]);
                Node node2 = getNodeByName(split3[1]);

                // node1 <- node2
                node2.addNeighbor(node1);

            } else {
                throw new InvalidGraphConfigurationException("Invalid edge syntax: Cannot find a matching edge type for this directed edge.");
            }

        } else {
            if (edge.contains("->") || edge.contains("<-")) {
                throw new InvalidGraphConfigurationException("Undirected graphs must NOT contain arrows ('->' or '<-') in the edge definitions.");
            }

            edge = edge.trim();
            edge.split("-");
            // TODO: Parse edges of undirected graph

        }
    }

    /**
     * Looks up a node that has the given node name.
     * Returns only the first match. Ignores upper or lower case.
     *
     * @param nodeName The name of the node
     * @return the matching node
     * @throws NodeNotFoundException              if no matching node has been found
     * @throws InvalidGraphConfigurationException if the edge was malformed
     */
    public Node getNodeByName(String nodeName) throws NodeNotFoundException, InvalidGraphConfigurationException {

        nodeName = nodeName.trim();

        if (nodeName.contains("<") || nodeName.contains(">") || nodeName.contains("-")) {
            throw new InvalidGraphConfigurationException("Invalid edge syntax: '" + nodeName + "' is not a valid node name");
        }

        for (Node node : nodes) {
            if (node.getName().equalsIgnoreCase(nodeName.trim())) {
                return node;
            }
        }
        throw new NodeNotFoundException(nodeName);
    }

    /**
     * Returns the number of nodes in this graph.
     *
     * @return the number of nodes in this graph
     */
    public int getNodeCount() {
        return nodes.size();
    }
}
