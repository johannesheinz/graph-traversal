Graph traversal algorithms
==========================

A simple implementation of several graph traversal strategies such as depth-first search (DFS) and breadth-first search (BFS). From a given configuration the application generates a HTML table of the steps of the process as well as an animated gif file.


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

 - **`directed`:** `boolean` - `true` if this is a directed graph, `false` if this is an undirected graph
 - **`edges`:** `Array of Strings` - A list of all edges within the graph, for specification see below
 - **`nodes`:** `Array of Strings` - A list of all vertices specified by their names, e.g. `["a", "b", "c"]`
 - **`output`:** `Array of Strings` - All selected output formats, either `[]`, `["table"]`, `["gif"]` or `["table","gif"]`
 - **`startNode`:** `String` - name of the start node
 - **`strategy`:** `String` - either `"dfs"`, or `"bfs"`

A sample configuration can be found in the [resource files](https://raw.githubusercontent.com/johannesheinz/graphtraversal/master/src/main/resources/sample-configuration.json).

### How to define edges?




The correct syntax of the edges is checked while the 

### How to pass my JSON configuration to the application?

    //TODO Parameters in Maven AND jar file


Acknowledgments
---------------

    //TODO Jackson, table CSS, gif animation Code, 

