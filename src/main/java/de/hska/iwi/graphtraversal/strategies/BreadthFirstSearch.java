package de.hska.iwi.graphtraversal.strategies;

import de.hska.iwi.graphtraversal.graph.Graph;
import de.hska.iwi.graphtraversal.graph.Node;
import de.hska.iwi.graphtraversal.graph.State;

import java.util.List;
import java.util.Queue;

/**
 *  Algorithmus BFS
 *  ---------------
 *  01  Enqueue(Q, s);
 *  02  Markiere s;
 *  03  N[s] := Menge ls aller Nachfolgerknoten von s;
 *  04  d[s] := 0;
 *  05  while not Queue-empty(Q) do {
 *  06     v := head(Q);
 *  07     if N[v] != ∅ then {
 *  08         Wähle v' ∈ N[v];
 *  09         N[v] := N[v] \ {v'};
 *  10         if (v' ist noch nicht markiert) then {
 *  11             Enqueue(Q, v');
 *  12             Markiere v';
 *  13             N[v'] := Menge lv' aller Nachfolgerknoten von v';
 *  14             d[v'] := d[v] + 1;
 *  15         }
 *  16     } else Dequeue(Q);
 *  17  
 */
public class BreadthFirstSearch implements GraphTraversalStrategy {

    private Queue<Node> queue;

    @Override
    public List<State> traverseGraph(Graph graph, Node startNode) {

        // TODO: BreadthFirstSearch

        return null;
    }
}
