package az.amirashad.trainsandtowns.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path implements Comparable<Path> {

    private final List<Edge> edgeList = new ArrayList<>();
    private int totalWeight = 0;

    private Path() {
    }

    private Path(final Path otherPath) {
        edgeList.addAll(otherPath.getEdgeList());
        this.totalWeight = otherPath.getPathTotalWeight();
    }

    public static Path emptyPath() {
        return new Path();
    }

    public static Path copyPath(final Path otherPath) {
        return new Path(otherPath);
    }

    public void addEdge(final Edge edge) {
        if (!edgeIsConsecutive(edge)) {
            throw new IllegalArgumentException("The edge " + edge + " is not consecutive to the existing path");
        }
        edgeList.add(edge);
        totalWeight += edge.getWeight();
    }

    private boolean edgeIsConsecutive(final Edge edge) {
        final String lastNode = getLastNode();
        return lastNode == null || lastNode.equals(edge.getStartingVertex());
    }

    public int getPathTotalWeight() {
        return totalWeight;
    }

    public int getNumberOfHops() {
        return edgeList.size();
    }

    public String getLastNode() {
        String node = null;
        if (!edgeList.isEmpty()) {
            node = edgeList.get(edgeList.size() - 1).getEndingVertex();
        }
        return node;
    }

    public void removeLastEdge() {
        if (!edgeList.isEmpty()) {
            final Edge lastEdge = edgeList.get(edgeList.size() - 1);
            this.totalWeight -= lastEdge.getWeight();
            edgeList.remove(edgeList.size() - 1);
        }
    }

    private List<Edge> getEdgeList() {
        return Collections.unmodifiableList(edgeList);
    }

    public boolean hasRepeatedEdges() {
        for (int i = 0; i < edgeList.size(); i++) {
            for (int j = i + 1; j < edgeList.size(); j++) {
                if (edgeList.get(i).equals(edgeList.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean startsWith(final Path otherPath) {
        final List<Edge> partialPath = otherPath.getEdgeList();
        final List<Edge> completePath = getEdgeList();
        for (int i = 0; i < partialPath.size(); i++) {
            if (i >= completePath.size() || !partialPath.get(i).equals(completePath.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Path (" + totalWeight + ") [edgeList=" + edgeList + "]";
    }

    @Override
    public int compareTo(final Path otherPath) {
        return this.getPathTotalWeight() - otherPath.getPathTotalWeight();
    }

}
