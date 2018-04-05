package az.amirashad.trainsandtowns.graph;

public class Edge {
    private final String startingVertex;
    private final String endingVertex;
    private final int weight;

    public Edge(final String startingVertex, final String endingVertex, final int weight) {
        this.startingVertex = startingVertex;
        this.endingVertex = endingVertex;
        this.weight = weight;
    }

    public String getStartingVertex() {
        return startingVertex;
    }

    public String getEndingVertex() {
        return endingVertex;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + startingVertex + ", " + endingVertex + "); ";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (endingVertex == null ? 0 : endingVertex.hashCode());
        result = prime * result + (startingVertex == null ? 0 : startingVertex.hashCode());
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (endingVertex == null) {
            if (other.endingVertex != null) {
                return false;
            }
        } else if (!endingVertex.equals(other.endingVertex)) {
            return false;
        }
        if (startingVertex == null) {
            return other.startingVertex == null;
        } else {
            return startingVertex.equals(other.startingVertex);
        }
    }

}
