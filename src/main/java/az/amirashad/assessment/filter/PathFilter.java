package az.amirashad.assessment.filter;

import az.amirashad.assessment.graph.Path;

public interface PathFilter {
    boolean passFilter(final Path path);
}
