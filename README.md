Graph traversal algorithms
==========================

A simple implementation of several graph traversal strategies such as depth-first search (DFS) and breadth-first search (BFS). From a given JSON configuration the application generates a HTML table containing the state of the graph at each iteration as well as an animated gif file.


Requirements
------------

 - A current version of [Apache Maven](https://maven.apache.org/)
 - [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) in version 8 or higher


Execution
---------

### Build application

    mvn clean install

### Run main application

    mvn clean install exec:java

### Export as \*.jar file including libraries

    mvn clean package

### Excute packaged \*.jar file

    java -jar graphtraversal-1.0-SNAPSHOT-jar-with-dependencies.jar


Configuration
-------------

The application can be configured via a JSON file that contains the following properties:

| Property        | Type       | Description                                                                           | Example            |
| --------------- | ---------- | ------------------------------------------------------------------------------------- | ------------------ |
| **`directed`**  | `boolean`  | `true` if this is a directed graph, `false` if this is an undirected graph            | `true`             |
| **`edges`**     | `String[]` | A list of all edges within the graph, for [specification see below](#how-to-define-edges) | `["a->b", "b->c"]` |
| **`nodes`**     | `String[]` | A list of all vertices specified by their names                                       | `["a", "b", "c"]`  |
| **`output`**    | `String[]` | A list of the selected output formats, either `[]`, `["table"]`, `["gif"]` or `["table","gif"]` | `["table"]`        |
| **`startNode`** | `String`   | The name of the start node                                                            | `"a"`              |
| **`strategy`**  | `String`   | The name of the search strategy, either `"dfs"`, or `"bfs"`                           | `"dfs"`            |

A sample configuration can be found in the [resource files](https://raw.githubusercontent.com/johannesheinz/graphtraversal/master/src/main/resources/sample-configuration.json).

### How to define edges?

There are two different specifications depending on the type of the graph:

**Edges in directed graphs:** 

In directed graphs there are 3 types of edges:

 - `a-->b`: There is an edge from node "a" to node "b", but not in the opposite direction (unidirectional)
 - `a<--b`: There is an edge from node "b" to node "a", but not in the opposite direction (unidirectional)
 - `a<->c`: There is both, an edge from "a" to "b" and an edge from "b" to "a" (bidirectional)

**Edges in undirected graphs:** 

In undirected graphs there in only one edge type:

 - `a-b`: There is an edge between node "a" and node "b" (bidirectional)

You may add whitespaces and change the number of dashes:

| :heavy_check_mark: Correct syntax | :x: False syntax |
|----------------|--------------|
|   `a->b`       |  `a>b`       |
|   `a -> b`     |  `a > b`     |
|   `a-> b`      |  `a - > b`   |
|   ` a -> b `   |  `a- >b`     |
|   `a------>b`  |  `a - - >b`  |
|   `a --> b`    |  `a- -b`     |
|   ` a-b `      |              |
|   `a - b`      |              |
|   `a --- b`    |              |

The **correct syntax** of the edges is checked when the application reads and parses the JSON file.

### How to pass my JSON configuration to the application?

    //TODO Parameters in Maven AND jar file


Sample
------

As an example there is the following sample graph specified:

    //TODO Sample graph


Acknowledgments
---------------

    //TODO Jackson, table CSS, gif animation Code, 

