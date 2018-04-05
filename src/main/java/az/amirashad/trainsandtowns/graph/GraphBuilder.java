package az.amirashad.trainsandtowns.graph;

public class GraphBuilder {
    public static final String CLI_GRAPH_TEXT = "Graph:";

    public static Graph buildFromCLI(String[] args) {
        Graph graph = new Graph();

        for (String s : args) {
            if (s.equalsIgnoreCase(CLI_GRAPH_TEXT)) {
                continue;
            }
            final String trimmedPair = s.trim().replace(",", "");
            final String from = String.valueOf(trimmedPair.charAt(0));
            final String to = String.valueOf(trimmedPair.charAt(1));
            final int weight = Integer.valueOf(trimmedPair.substring(2));
            graph.addVertex(from);
            graph.addVertex(to);
            graph.addEdge(from, to, weight);
        }

        return graph;
    }

}
