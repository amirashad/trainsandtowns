package az.amirashad.trainsandtowns.filter;

import az.amirashad.trainsandtowns.graph.Path;

public interface PathFilter {
    boolean passFilter(final Path path);
}
