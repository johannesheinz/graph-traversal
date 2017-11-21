package de.hska.iwi.graphtraversal;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;
import de.hska.iwi.graphtraversal.input.GraphConfiguration;
import de.hska.iwi.graphtraversal.input.InvalidGraphConfigurationException;
import de.hska.iwi.graphtraversal.input.NodeNotFoundException;
import de.hska.iwi.graphtraversal.input.JsonReader;
import de.hska.iwi.graphtraversal.output.Exporter;
import de.hska.iwi.graphtraversal.output.GifCreator;
import de.hska.iwi.graphtraversal.output.TableWriter;
import de.hska.iwi.graphtraversal.strategies.DepthFirstSearch;
import de.hska.iwi.graphtraversal.strategies.GraphTraversalStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.hska.iwi.graphtraversal.input.GraphConfiguration.Output.GIF;
import static de.hska.iwi.graphtraversal.input.GraphConfiguration.Output.TABLE;
import static de.hska.iwi.graphtraversal.input.GraphConfiguration.Strategy.BFS;
import static de.hska.iwi.graphtraversal.input.GraphConfiguration.Strategy.DFS;

/**
 * The main application that reads the graph configuration from a JSON file. and executes the selected strategy.
 */
public class Application {

    public static void main(String[] args) {

        final String input = "sample-configuration.json";
        final String output = "sample-output";

        // Read configuration from JSON file
        JsonReader reader = new JsonReader();
        GraphConfiguration configuration = reader.readConfig(input);

        Graph graph = new Graph(configuration);

        System.out.println(graph);

        Map<GraphConfiguration.Strategy, GraphTraversalStrategy> strategies = new HashMap<>();
        strategies.put(DFS, new DepthFirstSearch(graph));
        strategies.put(BFS, new DepthFirstSearch(graph));

        GraphTraversalStrategy strategy = strategies.get(configuration.getStrategy());
        
        List<State> log = new ArrayList<>();
        final String startNodeName = configuration.getStartNode();
        
        try {
            Node startNode = graph.getNodeByName(startNodeName);
            
            // Traverse graph with the selected strategy
            log = strategy.traverseGraph(startNode);
            
        } catch (NodeNotFoundException e) {
            throw new InvalidGraphConfigurationException("Invalid start node '" + startNodeName + "': There is no node with this name in the graph.");
        }
        
        // Export logged results with the selected outputs
        Map<GraphConfiguration.Output, Exporter> outputs = new HashMap<>();
        outputs.put(TABLE, new TableWriter(output, strategy.getName(), strategy.getName()));
        outputs.put(GIF, new GifCreator(output));

        if (configuration.getOutput() != null) {
            for (GraphConfiguration.Output key : configuration.getOutput()) {
                outputs.get(key).exportResults(log);
            }
        }
    }
}
