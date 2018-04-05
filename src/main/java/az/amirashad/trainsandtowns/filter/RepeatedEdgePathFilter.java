package az.amirashad.trainsandtowns.filter;

import az.amirashad.trainsandtowns.graph.Path;

public class RepeatedEdgePathFilter implements PathFilter {

    @Override
    public boolean passFilter(final Path path) {
        return !path.hasRepeatedEdges();
    }

}
