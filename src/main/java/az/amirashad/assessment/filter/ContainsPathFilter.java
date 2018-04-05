package az.amirashad.assessment.filter;

import az.amirashad.assessment.graph.Path;

public class ContainsPathFilter implements PathFilter {
    private final Path objectivePath;

    public ContainsPathFilter(final Path objectivePath) {
        this.objectivePath = objectivePath;
    }

    @Override
    public boolean passFilter(final Path path) {
        return objectivePath.startsWith(path);
    }

}
