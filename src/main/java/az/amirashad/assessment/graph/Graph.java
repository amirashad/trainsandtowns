package az.amirashad.assessment.graph;

import az.amirashad.assessment.exception.NoSuchRouteException;
import az.amirashad.assessment.filter.PathFilter;

import java.util.*;


public class Graph {
    private final Map<String, Set<Edge>> edges = new HashMap<>();

    public boolean addVertex(final String vertex) {
        assertVertexNotNull(vertex);
        if (!edges.containsKey(vertex)) {
            edges.put(vertex, new LinkedHashSet<>());
            return true;
        }
        return false;
    }

    private void assertVertexNotNull(final String vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex can not be null");
        }
    }

    public boolean addEdge(final String from, final String to, final int weight) {
        assertVertexExists(from);
        assertVertexExists(to);

        final Edge newEdge = new Edge(from, to, weight);

        final Set<Edge> sourceEdges = edges.get(from);

        if (sourceEdges.contains(newEdge)) {
            sourceEdges.remove(newEdge);
        }

        return edges.get(from).add(newEdge);
    }

    private void assertVertexExists(final String vertex) {
        if (!edges.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " does not exist");
        }
    }

    public Edge getEdge(final String from, final String to) {
        assertVertexExists(from);
        assertVertexExists(to);

        final Set<Edge> startingVertexEdges = edges.get(from);
        for (final Edge eachEdge : startingVertexEdges) {
            if (eachEdge.getEndingVertex().equals(to)) {
                return eachEdge;
            }
        }
        return null;
    }

    public List<Path> getAllPaths(final String startingNode, final String endingNode, final PathFilter filter) {
        assertVertexExists(startingNode);
        assertVertexExists(endingNode);

        final List<Path> paths = new ArrayList<>();
        for (final Edge each : edges.get(startingNode)) {
            final Path path = Path.emptyPath();
            path.addEdge(each);
            paths.addAll(search(path, filter, endingNode));
        }

        if (paths.isEmpty()) {
            throw new NoSuchRouteException(startingNode, endingNode);
        }
        return paths;
    }


    private List<Path> search(final Path path, final PathFilter filter, final String end) {
        final List<Path> paths = new ArrayList<>();
        if (filter.passFilter(path)) {
            if (hasReachedGoal(path, end)) {
                paths.add(Path.copyPath(path));
            }
            for (final Edge each : edges.get(path.getLastNode())) {
                path.addEdge(each);
                paths.addAll(search(path, filter, end));
            }

        }
        path.removeLastEdge();
        return paths;
    }

    private boolean hasReachedGoal(final Path path, final String end) {
        return path.getLastNode().equals(end);
    }

    public Set<String> getAllVertex() {
        return Collections.unmodifiableSet(edges.keySet());
    }

}
