package az.amirashad.assessment.filter;

import az.amirashad.assessment.graph.Path;

public class RepeatedEdgePathFilter implements PathFilter {

    @Override
    public boolean passFilter(final Path path) {
        return !path.hasRepeatedEdges();
    }

}
